package myRobot;

import robocode.*;

/**
 * TestRobot - a robot by Stranger
 */
public class TigerDiff extends AdvancedRobot 
{
        Enemy enemy = new Enemy();
        public static double PI = Math.PI;
        double gunTurnAmt; // How much to turn our gun when searching
        int sign = 0;
        
        //walls
        boolean peek; // Don't turn if there's a robot there
        double moveAmount; // How much to move
        
        public void run() 
        { 
        		if(sign == 0)
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
        		else //walls
        		{
        			// Initialize moveAmount to the maximum possible for this battlefield.
        			moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
        			// Initialize peek to false
        			peek = false;
        			turnLeft(getHeading() % 90);
        			ahead(moveAmount);
        			// Turn the gun to turn right 90 degrees.
        			peek = true;
        			turnGunRight(90);
        			turnRight(90);

        			while (true) {
        				// Look before we turn when ahead() completes.
        				peek = true;
        				// Move up the wall
        				ahead(moveAmount);
        				// Don't look now
        				peek = false;
        				// Turn to the next wall
        				turnRight(90);
        			}
        		}
    }
    
    double life = 0;
    public void onScannedRobot(ScannedRobotEvent e) 
    { 
    		if(e.getEnergy() - getEnergy() > 20)
    		{
    			if(sign == 0)
    				sign = 1;
    			else 
    				sign = 0;
    		}
    		if(sign == 0)
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
    		else //walls
    		{
    			fire(2);
    			// Note that scan is called automatically when the robot is moving.
    			// By calling it manually here, we make sure we generate another scan event if there's a robot on the next
    			// wall, so that we do not start moving up it until it's gone.
    			if (peek) {
    				scan();
    			}
    		}
    }
    
	public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			back(100);
		}
		else {
			ahead(100);
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