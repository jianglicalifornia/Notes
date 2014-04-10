import java.util.Arrays;

public class Quaternion {

	 private double w, x, y, z; 

	    // create a new object with the given components
	    public Quaternion(double x0, double x1, double x2, double x3) {
	        this.w = x0;
	        this.x = x1;
	        this.y = x2;
	        this.z = x3;
	    }
	    
	    public float[] getData(){
	    	float[] data = new float[4];
	    	data[0] = (float)w;
	    	data[1] = (float)x;
	    	data[2] = (float)y;
	    	data[3] = (float)z;
	    	return data;
	    }

	    // return a string representation of the invoking object
	    public String toString() {
	        return w + " + " + x + "i + " + y + "j + " + z + "k";
	    }

	    // return the quaternion norm
	    public double norm() {
	        return Math.sqrt(w*w + x*x +y*y + z*z);
	    }
	    
	    public void normalize(){
	    	double norm = this.norm();
	    	w /= norm;
	    	x /= norm;
	    	y /= norm;
	    	z /= norm;
	    }

	    // return the quaternion conjugate
	    public Quaternion conjugate() {
	        return new Quaternion(w, -x, -y, -z);
	    }

	    // return a new Quaternion whose value is (this + b)
	    public Quaternion plus(Quaternion b) {
	        Quaternion a = this;
	        return new Quaternion(a.w+b.w, a.x+b.x, a.y+b.y, a.z+b.z);
	    }


	    // return a new Quaternion whose value is (this * b)
	    public Quaternion times(Quaternion b) {
	        Quaternion a = this;
	        double y0 = a.w*b.w - a.x*b.x - a.y*b.y - a.z*b.z;
	        double y1 = a.w*b.x + a.x*b.w + a.y*b.z - a.z*b.y;
	        double y2 = a.w*b.y - a.x*b.z + a.y*b.w + a.z*b.x;
	        double y3 = a.w*b.z + a.x*b.y - a.y*b.x + a.z*b.w;
	        return new Quaternion(y0, y1, y2, y3);
	    }

	    // return a new Quaternion whose value is the inverse of this
	    public Quaternion inverse() {
	        double d = w*w + x*x + y*y + z*z;
	        return new Quaternion(w/d, -x/d, -y/d, -z/d);
	    }


	    // return a / b
	    public Quaternion divides(Quaternion b) {
	         Quaternion a = this;
	        return a.inverse().times(b);
	    }

	    // returan difference between this and target quaternion
	    public Quaternion rotateto(Quaternion b){
	    	Quaternion a = this;
			Quaternion transition = a.times(b.inverse());
			return transition;
	    }
	    
	    /**
         * Converts this Quaternion to Euler rotation angles {@code roll}, {@code
         * pitch} and {@code yaw} in radians.
         * {@link #fromEulerAngles(float, float, float)} performs the inverse
         * operation. The code was adapted from:
         * http://www.euclideanspace.com/maths/geometry
         * /rotations/conversions/quaternionToEuler/index.htm.
         * <p>
         * <b>Attention:</b> This method assumes that this Quaternion is normalized.
         *
         * @return the PVector holding the roll (x coordinate of the vector), pitch (y
         *         coordinate of the vector) and yaw angles (z coordinate of the
         *         vector). <b>Note:</b> The order of the rotations that would produce
         *         this Quaternion (i.e., as with {@code fromEulerAngles(roll, pitch,
         *         yaw)}) is: y->z->x.
         *
         * @see #fromEulerAngles(float, float, float)
         */

        public double[] eulerAngles() {
        	double[] euler = new double[3];
            double roll, pitch, yaw;
            double test = (x * y + z * w);
            if (test > 0.499) { // singularity at north pole
                    pitch = 2 * Math.atan2(x, w);
                    yaw = Math.PI / 2;
                    roll = 0;
                    euler[0] = roll;
                    euler[1] = pitch;
                    euler[2] = yaw;
                    return euler;
            }
            if (test < -0.499) { // singularity at south pole
                    pitch = -2 * Math.atan2(x, w);
                    yaw = -Math.PI / 2;
                    roll = 0;
                    euler[0] = roll;
                    euler[1] = pitch;
                    euler[2] = yaw;
                    return euler;
            }
            double sqx = x * x;
            double sqy = y * y;
            double sqz = z * z;
            pitch = Math.atan2(2 * y * w - 2 * x * z, 1 - 2 * sqy - 2 * sqz);
            yaw = Math.asin(2 * test);
            roll = Math.atan2(2 * x * w - 2 * y * z, 1 - 2 * sqx - 2 * sqz);
            euler[0] = roll;
            euler[1] = pitch;
            euler[2] = yaw;
            return euler;            
    }


    private static void getQuaternionFromEuler(double roll, double pitch, double yaw, double[] quaternion){
    	double s1 = Math.sin(yaw/2);	
    	double s2 = Math.sin(pitch/2);	
    	double s3 = Math.sin(roll/2);	
    	
    	double c1 = Math.cos(yaw/2);
    	double c2 = Math.cos(pitch/2);
    	double c3 = Math.cos(roll/2);

    	quaternion[0] =  c1*c2*c3 - s1*s2*s3; //w 
    	quaternion[1] =  s1*s2*c3 + c1*c2*s3; //x
    	quaternion[2] =  s1*c2*c3 + c1*s2*s3; //y
    	quaternion[3] =  c1*s2*c3 - s1*c2*s3; //z
    }

	    // sample client for testing
	    public static void main(String[] args) {
	        Quaternion a = new Quaternion(0.5, 1.0, 0.0, 0.0);
			a.normalize();
	        System.out.println("a = " + a);

	        Quaternion b = new Quaternion(0.0, 5.0, 1.0, -2.0);
	        System.out.println("b = " + b);

	        System.out.println("norm(a)  = " + a.norm());
	        System.out.println("conj(a)  = " + a.conjugate());
	        System.out.println("a + b    = " + a.plus(b));
	        System.out.println("a * b    = " + a.times(b));
	        System.out.println("b * a    = " + b.times(a));
	        System.out.println("a / b    = " + a.divides(b));
	        System.out.println("a^-1     = " + a.inverse());
	        System.out.println("a^-1 * a = " + a.inverse().times(a));
	        System.out.println("a * a^-1 = " + a.times(a.inverse()));
	        System.out.println("euler angle(a) = " + Arrays.toString(a.eulerAngles()));
			double[] quaternion = new double[4];
			getQuaternionFromEuler(a.eulerAngles()[0], a.eulerAngles()[1], a.eulerAngles()[2], quaternion);
			System.out.println("back to quaternion from euler angle(a) = " + Arrays.toString(quaternion));
	        
		}

		public void setQuaternion(double x0, double x1, double x2, double x3) {
	        this.w = x0;
	        this.x = x1;
	        this.y = x2;
	        this.z = x3;
	    }

}
