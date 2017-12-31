package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by AidasJakubenas on 3/4/17.
 */

@Autonomous
public class RadicalAuto extends LinearOpMode {

    public DcMotor RightFrontDrive; //Sets DCMotor as RightFrontDrive
    public DcMotor LeftFrontDrive;  //Sets DCMotor as LeftFrontDrive
    public DcMotor RightBackDrive;  //Sets DCMotor as RightBackDrive
    public DcMotor LeftBackDrive;   //Sets DCMotor as LeftBackDrive
    public DcMotor LiftMotor;       //Sets DCMotor as LiftMotor
    public Servo LiftServo;         //Sets Servo as LiftServo
    public Servo LiftServo2;
    public DcMotor GrabberMotor;
    @Override
    public void runOpMode() throws InterruptedException {

        int oneRev = 28*40;
        int counter = 0;
        RightFrontDrive = hardwareMap.dcMotor.get("RightFrontDrive");
        LeftFrontDrive = hardwareMap.dcMotor.get("LeftFrontDrive");
        RightBackDrive = hardwareMap.dcMotor.get("RightBackDrive");
        LeftBackDrive = hardwareMap.dcMotor.get("LeftBackDrive");
        LiftMotor = hardwareMap.dcMotor.get("LiftMotor");
        LiftServo = hardwareMap.servo.get("LiftServo");
        LiftServo2 = hardwareMap.servo.get("LiftServo2");
        GrabberMotor = hardwareMap.dcMotor.get("GrabberMotor");

        LeftFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftBackDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LiftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();



        while  (counter == 0) {

            RightFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            LeftFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            LeftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LeftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LeftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            RightFrontDrive.setTargetPosition(oneRev);
            LeftFrontDrive.setTargetPosition(oneRev);
            RightBackDrive.setTargetPosition(oneRev);
            LeftBackDrive.setTargetPosition(oneRev);
            int curr = RightBackDrive.getCurrentPosition();
            telemetry.addLine("ONE");
            while(curr <= (oneRev*3)){
                RightFrontDrive.setPower(.75);
                LeftFrontDrive.setPower(.75);
                RightBackDrive.setPower(.75);
                LeftBackDrive.setPower(.75);
                curr = RightBackDrive.getCurrentPosition();
                telemetry.addLine("TWO");

            }
            RightFrontDrive.setPower(0);
            LeftFrontDrive.setPower(0);
            RightBackDrive.setPower(0);
            LeftBackDrive.setPower(0);
            counter++;
            telemetry.addLine("THREE");
        }

        sleep(1000);

        while  (counter == 1) {

            RightFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            LeftFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            LeftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LeftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LeftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            RightFrontDrive.setTargetPosition(oneRev);
            LeftFrontDrive.setTargetPosition(oneRev);
            RightBackDrive.setTargetPosition(oneRev);
            LeftBackDrive.setTargetPosition(oneRev);
            int curr = RightBackDrive.getCurrentPosition();
            telemetry.addLine("ONE");
            while(curr <= (oneRev*1.5)){
                RightFrontDrive.setPower(.50);
                LeftFrontDrive.setPower(-.50);
                RightBackDrive.setPower(.50);
                LeftBackDrive.setPower(-.50);
                curr = RightBackDrive.getCurrentPosition();
                telemetry.addLine("TWO");

            }
            RightFrontDrive.setPower(0);
            LeftFrontDrive.setPower(0);
            RightBackDrive.setPower(0);
            LeftBackDrive.setPower(0);
            counter++;
            telemetry.addLine("THREE");
        }

        sleep(1000);

        while  (counter == 2) {

            RightFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            LeftFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            LeftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LeftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LeftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            RightFrontDrive.setTargetPosition(oneRev);
            LeftFrontDrive.setTargetPosition(oneRev);
            RightBackDrive.setTargetPosition(oneRev);
            LeftBackDrive.setTargetPosition(oneRev);
            int curr = RightBackDrive.getCurrentPosition();
            telemetry.addLine("ONE");
            while(curr <= (oneRev*.5)){
                RightFrontDrive.setPower(.20);
                LeftFrontDrive.setPower(.20);
                RightBackDrive.setPower(.20);
                LeftBackDrive.setPower(.20);
                curr = RightBackDrive.getCurrentPosition();
                telemetry.addLine("TWO");

            }
            RightFrontDrive.setPower(0);
            LeftFrontDrive.setPower(0);
            RightBackDrive.setPower(0);
            LeftBackDrive.setPower(0);
            counter++;
            telemetry.addLine("THREE");
        }
    }
}
