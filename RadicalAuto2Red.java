package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.detectors.JewelDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**package org.firstinspires.ftc.teamcode;

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
public class RadicalAuto2Red extends LinearOpMode {

    JewelDetector jewelDetector = new JewelDetector();

    public DcMotor RightFrontDrive; //Sets DCMotor as RightFrontDrive
    public DcMotor LeftFrontDrive;  //Sets DCMotor as LeftFrontDrive
    public DcMotor RightBackDrive;  //Sets DCMotor as RightBackDrive
    public DcMotor LeftBackDrive;   //Sets DCMotor as LeftBackDrive
    public DcMotor LiftMotor;
    public Servo Servo1;
    public Servo Servo2;
    public Servo Servo3;
    public Servo Servo4;
    public Servo Servo5;
    public Servo Servo6;

    @Override
    public void runOpMode() throws InterruptedException {

        jewelDetector.init(hardwareMap.appContext, CameraViewDisplay.getInstance());
        jewelDetector.areaWeight = 0.02;
        jewelDetector.detectionMode = JewelDetector.JewelDetectionMode.MAX_AREA;
        jewelDetector.debugContours = true;
        jewelDetector.maxDiffrence = 15;
        jewelDetector.ratioWeight = 15;
        jewelDetector.minArea = 700;
        jewelDetector.rotateMat = true;

        int oneRev = 28 * 40;
        int counter = 0;
        RightFrontDrive = hardwareMap.dcMotor.get("RightFrontDrive");
        LeftFrontDrive = hardwareMap.dcMotor.get("LeftFrontDrive");
        RightBackDrive = hardwareMap.dcMotor.get("RightBackDrive");
        LeftBackDrive = hardwareMap.dcMotor.get("LeftBackDrive");
        LiftMotor = hardwareMap.dcMotor.get("LiftMotor");
        Servo1 = hardwareMap.servo.get("Servo1");
        Servo2 = hardwareMap.servo.get("Servo2");
        Servo3 = hardwareMap.servo.get("Servo3");
        Servo4 = hardwareMap.servo.get("Servo4");
        Servo5 = hardwareMap.servo.get("Servo5");
        Servo6 = hardwareMap.servo.get("Servo6");

        LeftFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftBackDrive.setDirection(DcMotorSimple.Direction.REVERSE);


        waitForStart();
        jewelDetector.enable();
        while (opModeIsActive()) {


            if (counter == 0) {
                if (jewelDetector.getLastOrder() != JewelDetector.JewelOrder.UNKNOWN) {
                    telemetry.addLine("Found JUUL:  ");
                    telemetry.addLine(jewelDetector.getLastOrder().toString());
                }
                if (jewelDetector.getLastOrder() == JewelDetector.JewelOrder.RED_BLUE) {
                    Servo5.setPosition(1);
                    Servo6.setPosition(0);
                    sleep(500);
                    Servo6.setPosition(0.313);
                    sleep(1000);
                    Servo5.setPosition(0.313);
                    sleep(1000);
                    Servo6.setPosition(0.19);
                    sleep(1000);
                    Servo5.setPosition(0.117);
                    sleep(1000);
                    Servo6.setPosition(0.19);
                    sleep(1000);
                    Servo5.setPosition(0.313);
                    sleep(1000);
                    Servo6.setPosition(0.313);
                    sleep(500);
                    Servo5.setPosition(1);
                    Servo6.setPosition(0);
                    counter++;
                    jewelDetector.disable();

                } else if (jewelDetector.getLastOrder() == JewelDetector.JewelOrder.BLUE_RED) {
                    Servo5.setPosition(1);
                    Servo6.setPosition(0);
                    sleep(500);
                    Servo6.setPosition(0.313);
                    sleep(1000);
                    Servo5.setPosition(0.313);
                    sleep(1000);
                    Servo6.setPosition(0.19);
                    sleep(1000);
                    Servo5.setPosition(0.588);      //THIS VALUE CHANGES FOR LEFT OR RIGHT
                    sleep(1000);
                    Servo6.setPosition(0.19);
                    sleep(1000);
                    Servo5.setPosition(0.313);
                    sleep(1000);
                    Servo6.setPosition(0.313);
                    sleep(500);
                    Servo5.setPosition(1);
                    Servo6.setPosition(0);
                    counter++;
                    jewelDetector.disable();
                }
            }

            while (counter == 1) {

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

                Servo1.setPosition(.35);
                Servo2.setPosition(.25);
                LiftMotor.setPower(.5);
                sleep(1000);
                LiftMotor.setPower(0);
                sleep(1000);

                int curr = RightBackDrive.getCurrentPosition();
                telemetry.addLine("ONE");
                while (curr <= (oneRev * 2)) {
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

                LiftMotor.setPower(-.5);
                sleep(400);
                LiftMotor.setPower(0);
                sleep(1000);

            }

            sleep(1000);

            while (counter == 2) {
                sleep(1000);
                RightFrontDrive.setPower(.5);
                LeftFrontDrive.setPower(-.5);
                RightBackDrive.setPower(.5);
                LeftBackDrive.setPower(-.5);
                sleep(500);
                RightFrontDrive.setPower(0);
                LeftFrontDrive.setPower(0);
                RightBackDrive.setPower(0);
                LeftBackDrive.setPower(0);
                counter++;
                telemetry.addLine("THREE");


            }

            sleep(1000);

            while (counter == 3) {

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
                while (curr <= (oneRev * 1)) {
                    RightFrontDrive.setPower(.5);
                    LeftFrontDrive.setPower(.5);
                    RightBackDrive.setPower(.5);
                    LeftBackDrive.setPower(.5);
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


            while (counter == 4) {

                RightFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                LeftFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                RightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                LeftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                RightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                LeftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                RightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                LeftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                Servo1.setPosition(0);
                Servo2.setPosition(.5);

                sleep(500);

                RightFrontDrive.setTargetPosition(oneRev);
                LeftFrontDrive.setTargetPosition(oneRev);
                RightBackDrive.setTargetPosition(oneRev);
                LeftBackDrive.setTargetPosition(oneRev);
                telemetry.addLine("ONE");

                RightFrontDrive.setPower(-.20);
                LeftFrontDrive.setPower(-.20);
                RightBackDrive.setPower(-.20);
                LeftBackDrive.setPower(-.20);
                telemetry.addLine("TWO");

                sleep(500);

                RightFrontDrive.setPower(0);
                LeftFrontDrive.setPower(0);
                RightBackDrive.setPower(0);
                LeftBackDrive.setPower(0);
                counter++;
                telemetry.addLine("THREE");
            }
        }
    }
}