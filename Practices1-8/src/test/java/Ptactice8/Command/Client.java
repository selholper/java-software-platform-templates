package Ptactice8.Command;

import Practice8.Command.Light;
import Practice8.Command.RemoteControl;
import Practice8.Command.TurnOffLightCommand;
import Practice8.Command.TurnOnLightCommand;

public class Client {
    public static void main(String[] args) {
        Light light = new Light();
        TurnOnLightCommand turnOnLightCommand = new TurnOnLightCommand(light);
        TurnOffLightCommand turnOffLightCommand = new TurnOffLightCommand(light);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(turnOnLightCommand);
        remoteControl.pressButton();
        remoteControl.setCommand(turnOffLightCommand);
        remoteControl.pressButton();
    }
}
