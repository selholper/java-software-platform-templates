package com.example.practice22.services;

import com.example.practice22.mbeans.DataClearAndExportTaskMBean;
import com.example.practice22.models.Student;
import com.example.practice22.models.University;
import com.example.practice22.repositories.StudentRepository;
import com.example.practice22.repositories.UniversityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.management.*;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
@EnableScheduling
@AllArgsConstructor
@Slf4j
public class SchedulerService implements DataClearAndExportTaskMBean, DynamicMBean {

    private static final String PATH = "database";
    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;

    @Scheduled(fixedRateString = "PT030M")
    public void dataClearAndExportTask() {
        clearDirectory();
        exportEntityDataIntoFiles();
    }

    private void clearDirectory() {
        Path directory = Paths.get(PATH);

        try (Stream<Path> walked = Files.walk(directory)) {
            walked
                .filter(Files::isRegularFile)
                .map(Path::toFile).forEach(File::delete);
            log.info("Delete all files in directory: {}", directory);
        } catch (IOException e) {
            log.error("Error while deleting {} directory files", directory, e);
        }
    }

    private void exportEntityDataIntoFiles() {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            String filePath = "student_" + student.getId() + ".txt";
            Path fullPath = Paths.get(PATH, filePath);

            try {
                Files.write(fullPath, student.toString().getBytes());
            } catch (IOException e) {
                log.error("Error while writing to file {}", filePath, e);
            }
            log.info("Export student {} to {}", student.getId(), fullPath);
        }

        List<University> universities = universityRepository.findAll();
        for (University university : universities) {
            String filePath = "university_" + university.getId() + ".txt";
            Path fullPath = Paths.get(PATH, filePath);

            try {
                Files.write(fullPath, university.toString().getBytes());
            } catch (IOException e) {
                log.error("Error while writing to file {}", fullPath, e);
            }
            log.info("Export university {} to {}", university.getId(), fullPath);
        }
    }

    @Override
    public void executeTask() {
        clearDirectory();
        exportEntityDataIntoFiles();
    }

    @Override
    public Object getAttribute(String attribute) throws AttributeNotFoundException {
        throw new AttributeNotFoundException(attribute);
    }

    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException {
        throw new AttributeNotFoundException(attribute.getName());
    }

    @Override
    public AttributeList getAttributes(String[] attributes) {
        return new AttributeList();
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        return new AttributeList();
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws ReflectionException {
        if (actionName.equals("executeTask")) {
            executeTask();
            return null;
        }
        throw new ReflectionException(new NoSuchMethodException(actionName));
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        return new MBeanInfo(
                this.getClass().getName(),
                "DataClearAndExportTask MBean",
                new MBeanAttributeInfo[0],
                null,
                new MBeanOperationInfo[]{
                        new MBeanOperationInfo("executeTask", "Execute data clear and export task",
                                null, "void", MBeanOperationInfo.ACTION)
                },
                null
        );
    }

    public static void registerMBean(
            StudentRepository studentRepository,
            UniversityRepository universityRepository) throws Exception {
        ManagementFactory.getPlatformMBeanServer()
                .registerMBean(new SchedulerService(studentRepository, universityRepository),
                        new ObjectName("scheduler:type=SchedulerService"));
    }
}
