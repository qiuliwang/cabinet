package myRobot;
import static robocode.util.Utils.normalRelativeAngleDegrees;

import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * TestRobot - a robot by Stranger
 */
public class Tiger extends AdvancedRobot 
{
        Enemy enemy = new Enemy();
        public static double PI = Math.PI;
        double gunTurnAmt; // How much to turn our gun when searching
 
        public void run() 
        { 
                setAdjustGunForRobotTurn( true ); 
                setAdjustRadarForGunTurn( true );         
                while(true){
                        if(enemy.name == null){
                                setTurnRadarRightRadians(2*PI); 
                                execute(); 
                        }
                        else{
                                execute();
                        }
                        turnRadarLeft(90);
                }
    }
    
    double life = 0;
    public void onScannedRobot(ScannedRobotEvent e) 
    { 
        enemy.update(e,this); 
        
        double Offset = rectify( enemy.direction - getRadarHeadingRadians()); 
        setTurnRadarRightRadians( Offset*1.5); 
        
        double gunTurn = enemy.direction - getGunHeadingRadians();
        setTurnGunRightRadians(rectify(gunTurn));

        double headTurn = enemy.direction - getHeadingRadians();
        setTurnRightRadians(rectify(headTurn));
        if (enemy.distance > 100) {
            setAhead(enemy.distance/5);
        }
        else
        {
            setBack(100-enemy.distance);
        }
        execute();
        if (enemy.distance > 400) 
        {
        		fire(1);
        }
        else if(enemy.distance > 300)
        {	
        		fire(2);
        }
        else
        {
            fire(3);
        }
    }
    
    	public double rectify ( double angle ) 
    	{ 
    		if ( angle < -Math.PI ) 
    			angle += 2*Math.PI; 
    		if ( angle > Math.PI ) 
    			angle -= 2*Math.PI; 
    		return angle; 
    	}
    	public class Enemy {
    		public double x,y;
        public String name = null;
        public double headingRadian = 0.0D; 
        public double bearingRadian = 0.0D; 
        public double distance = 1000D; 
        public double direction = 0.0D; 
        public double velocity = 0.0D; 
        public double prevHeadingRadian = 0.0D; 
        public double energy = 100.0D; 
        
        
        public void update(ScannedRobotEvent e,AdvancedRobot me){
        		name = e.getName();
        		headingRadian = e.getHeadingRadians();
            bearingRadian = e.getBearingRadians();
            this.energy = e.getEnergy();
            this.velocity = e.getVelocity();
            this.distance = e.getDistance();
            direction = bearingRadian + me.getHeadingRadians(); 
            x = me.getX() + Math.sin( direction ) * distance; 
            y = me.getY() + Math.cos( direction ) * distance;    
        }
    }
}