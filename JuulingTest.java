package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.detectors.JewelDetector;
import com.disnodeteam.dogecv.math.Line;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by AidasJakubenas on 2/20/18.
 */
@Autonomous(group= "Matthew")
public class JuulingTest extends LinearOpMode{

    JewelDetector jewelDetector = new JewelDetector();





    @Override
    public void runOpMode(){
        jewelDetector.init(hardwareMap.appContext, CameraViewDisplay.getInstance());
        jewelDetector.areaWeight = 0.02;
        jewelDetector.detectionMode = JewelDetector.JewelDetectionMode.MAX_AREA;
        jewelDetector.debugContours = true;
        jewelDetector.maxDiffrence = 15;
        jewelDetector.ratioWeight = 15;
        jewelDetector.minArea = 700;




        waitForStart();
        jewelDetector.enable();

        while (opModeIsActive()){
            if (jewelDetector.getLastOrder() != JewelDetector.JewelOrder.UNKNOWN){
                telemetry.addLine("Found JUUL:  ");
                telemetry.addLine(jewelDetector.getLastOrder().toString());
            }
        }

        if(jewelDetector.getLastOrder() == JewelDetector.JewelOrder.RED_BLUE) {

        }


    }








}
