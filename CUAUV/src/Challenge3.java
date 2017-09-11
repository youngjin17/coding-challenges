public class Challenge3 {

	// Sets the sub's x (forward) velocity to x_vel. A positive value here will move the sub forward. 
	public void set_x_velocity(double x_vel);

	// Sets the sub's y (strafing) velocity to y_vel. A positive value here will move the sub to the right.  
	public void set_y_velocity(double y_vel);

	// Sets the sub's z (depth) velocity to z_vel. A positive value here will move the sub downward.
	public void set_z_velocity(double z_vel);

	// The top left of the camera image has coordinates (0, 0) 
	public int buoy_x_pixel(); // Returns the x-coordinate of the pixel in the center of the buoy
	public int buoy_y_pixel(); // Returns the y-coordinate of the pixel in the center of the buoy

	private int CAMERA_WIDTH_PIXELS; // the width of the camera screen in pixels 
	private int CAMERA_HEIGHT_PIXELS; // the height of the camera screen in pixels 
	
	public static void main(String[] args) {
		ram();
	}
	
	public void ram() {
		int originX = CAMERA_WIDTH_PIXELS/2;
		int originY = CAMERA_HEIGHT_PIXELS/2;
		int diameter = 10; //This can change depending on the size of the ball
		while (Math.abs(buoy_x_pixel() - originX) > diameter && Math.abs(buoy_y_pixel() - originY) > diameter) {
			if (buoy_x_pixel() - originX < 0)
				set_x_velocity(-1);
			else
				set_x-velocity(1);
			if (buoy_y_pixel() - originY < 0)
				set_y_velocity(-1);
			else
				set_y_velocity(1);
		}
		set_x_velocity(1); //or whatever the max velocity can be
		set_y_velocity(0);
		set_z_velocity(0);
	}
}
