package org.firstinspires.ftc.teamcode;

import com.qualcomm.ftccommon.configuration.ScannedDevices;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
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
    public Servo LiftServo;         //Sets Servo as LiftServo
    public Servo LiftServo2;
    public DcMotor GrabberMotor;
    public DcMotor BottomGrabber;

    @Override
    public void init() {

        //Establish parts on the Hardware map
        RightFrontDrive = hardwareMap.dcMotor.get("RightFrontDrive");
        LeftFrontDrive = hardwareMap.dcMotor.get("LeftFrontDrive");
        RightBackDrive = hardwareMap.dcMotor.get("RightBackDrive");
        LeftBackDrive = hardwareMap.dcMotor.get("LeftBackDrive");
        LiftMotor = hardwareMap.dcMotor.get("LiftMotor");
        LiftServo = hardwareMap.servo.get("LiftServo");
        LiftServo2 = hardwareMap.servo.get("LiftServo2");
        GrabberMotor = hardwareMap.dcMotor.get("GrabberMotor");
        BottomGrabber = hardwareMap.dcMotor.get("BottomGrabber");

        LeftFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftBackDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LiftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        GrabberMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        LiftServo.setPosition(.5);
        LiftServo2.setPosition(.4);
    }

    @Override
    public void loop() {
        float RightFrontDrivePower = (-(gamepad1.right_stick_y)/2); //Variables to set power of RightDrive
        float LeftFrontDrivePower = (-(gamepad1.left_stick_y)/2); //Variable to set power of LeftDrive
        float GrabberMotorPower = (-(gamepad2.left_stick_y)/3);
        float BottomGrabberPower = ((gamepad2.right_stick_y)/3);

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

        LiftMotor.setPower(-(gamepad2.right_trigger)/2);
        LiftMotor.setPower((gamepad2.left_trigger)/2);
        GrabberMotor.setPower((GrabberMotorPower));
        BottomGrabber.setPower(BottomGrabberPower);

        //"A" opens servo
        if (gamepad2.a) {
            LiftServo.setPosition(.7);
        }
        //"B" closes servo
        else if (gamepad2.b) {
            LiftServo.setPosition(.1);
        }
        else if (gamepad2.x) {
            LiftServo2.setPosition(0);
        }
        else if (gamepad2.y) {
            LiftServo2.setPosition(1);
        }

        RightFrontDrive.setPower(RightFrontDrivePower);
        RightBackDrive.setPower(RightFrontDrivePower);
        LeftFrontDrive.setPower(LeftFrontDrivePower);
        LeftBackDrive.setPower(LeftFrontDrivePower);

    }
}
