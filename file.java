package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous(name="YourAuto", group="Autonomous")
//@Disabled
    /* Initialize standard Hardware interfaces */
public class basicControl extends LinearOpMode { //* Change name to your liking
    //* Variable Declaration
    MecanumHMap robot = new MecanumHMap(); //hardware map object
    ElapsedTime runtime = new ElapsedTime();
    //Main method, runs after init button pressed on DS
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        //*Initialization code (hardware)
        waitForStart();
        telemetry.addData("start", runtime.seconds());
        telemetry.update();
        while(opModeIsActive()) {
            if (gamepad1.right_stick_y==50) {
                runForward();
                telemetry.addData("moved forward", runtime.seconds());
                telemetry.update();
            }
        }
    }
    //* Robot goes forward 5 seconds
    public void runForward(){
        while(gamepad1.right_stick_y==50){
            robot.LTMotor.setPower(.9);
            robot.RTMotor.setPower(.9);
            robot.LBMotor.setPower(.9);
            robot.RBMotor.setPower(.9);
        }
        robot.LTMotor.setPower(0);
        robot.RTMotor.setPower(0);
        robot.LBMotor.setPower(0);
        robot.RBMotor.setPower(0);
    }
