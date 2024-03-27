package Practice8.Command;

import lombok.Setter;

@Setter
public class RemoteControl {
    private Command command;

    public void pressButton() {
        if (command != null) {
            command.execute();
        }
    }
}
