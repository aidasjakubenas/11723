package org.firstinspires.ftc.teamcode;

import com.qualcomm.ftccommon.configuration.ScannedDevices;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by Aidas Jakubenas and Justin Luk on 10/10/17
 */
@TeleOp
public class Radical extends OpMode {

    public DcMotor RightFrontDrive; //Sets DCMotor as RightFrontDrive
    public DcMotor LeftFrontDrive;  //Sets DCMotor as LeftFrontDrive
    public DcMotor RightBackDrive;  //Sets DCMotor as RightBackDrive
    public DcMotor LeftBackDrive;   //Sets DCMotor as LeftBackDrive
    public DcMotor LiftMotor;       //Sets DCMotor as LiftMotor
    public DcMotor GrabberMotor;
    public DcMotor BottomGrabber;
    public Servo Servo1;
    public Servo Servo2;
    public Servo Servo3;
    public Servo Servo4;

    @Override
    public void init() {

        //Establish parts on the Hardware map
        RightFrontDrive = hardwareMap.dcMotor.get("RightFrontDrive");
        LeftFrontDrive = hardwareMap.dcMotor.get("LeftFrontDrive");
        RightBackDrive = hardwareMap.dcMotor.get("RightBackDrive");
        LeftBackDrive = hardwareMap.dcMotor.get("LeftBackDrive");
        LiftMotor = hardwareMap.dcMotor.get("LiftMotor");
        GrabberMotor = hardwareMap.dcMotor.get("GrabberMotor");
        BottomGrabber = hardwareMap.dcMotor.get("BottomGrabber");
        Servo1 = hardwareMap.servo.get("Servo1");
        Servo2 = hardwareMap.servo.get("Servo2");
        Servo3 = hardwareMap.servo.get("Servo3");
        Servo4 = hardwareMap.servo.get("Servo4");

        LeftFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftBackDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LiftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        GrabberMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        Servo2.setDirection(Servo.Direction.REVERSE);

    }

    @Override
    public void loop() {
        float RightFrontDrivePower = (-(gamepad1.right_stick_y)/2); //Variables to set power of RightDrive
        float LeftFrontDrivePower = (-(gamepad1.left_stick_y)/2); //Variable to set power of LeftDrive

        RightFrontDrive.setPower(RightFrontDrivePower);
        RightBackDrive.setPower(RightFrontDrivePower);
        LeftFrontDrive.setPower(LeftFrontDrivePower);
        LeftBackDrive.setPower(LeftFrontDrivePower);


        while(gamepad1.right_trigger > 0) {
            LeftFrontDrive.setPower(-0.5);
            RightFrontDrive.setPower(0.5);
            LeftBackDrive.setPower(0.5);
            RightBackDrive.setPower(-0.5);
        }
        while(gamepad1.left_trigger > 0) {
            LeftFrontDrive.setPower(0.5);
            RightFrontDrive.setPower(-0.5);
            LeftBackDrive.setPower(-0.5);
            RightBackDrive.setPower(0.5);
        }
        while(gamepad2.right_trigger > 0) {
            LiftMotor.setPower(.4);
        }
        while(gamepad2.left_trigger > 0) {
            LiftMotor.setPower(-.4);
        }

        if (gamepad2.a) {
            Servo1.setPosition(.4);
            Servo2.setPosition(.1);
        }
        else if(gamepad2.b) {
            Servo1.setPosition(0);
            Servo2.setPosition(.5);
        }
        if (gamepad2.x) {
            Servo3.setPosition(.9);
            Servo4.setPosition(.1);
        }
        else if(gamepad2.y) {
            Servo3.setPosition(.5);
            Servo4.setPosition(.5);
        }


        LiftMotor.setPower(0);
    }
}
