
public class Body {
	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;
	
	
	public double getX() {
		return myXPos;
	}
/**
	public void setMyXPos(double myXPos) {
		this.myXPos = myXPos;
	}
	**/

	public double getY() {
		return myYPos;
	}
	
	public double getYVel() {
		return myYVel;
	}
	 
/**
	public void setMyYPos(double myYPos) {
		this.myYPos = myYPos;
	}
	**/

	public double getXVel() {
		return myXVel;
	}
/**
	public void setMyXVel(double myXVel) {
		this.myXVel = myXVel;
	}
	**/

	public double getMass() {
		return myMass;
	}
/**
	public void setMyMass(double myMass) {
		this.myMass = myMass;
	}
**/
	public String getName() {
		return myFileName;
	}
	/**

	public void setMyFileName(String myFileName) {
		this.myFileName = myFileName;
	}


**/
	
	public Body(double xp, double yp, double xv, double yv, double mass, String filename) {
	myXPos = xp;
	myYPos = yp;
	myXVel = xv;
	myYVel = yv;
	myMass = mass;
	myFileName = filename;
	
	
		
	}
	
	
	public Body(Body b) {
	

     this(b.getX(),b.getY(),b.getXVel(),b.getYVel(),b.getMass(),b.getName());
		
	}
	
	public double calcDistance(Body b) {
		double dist1 = Math.pow(myXPos-b.getX(), 2) + Math.pow(myYPos-b.getY(), 2);
		double dist = Math.sqrt(dist1);
		return dist;	
		
	}
	
	
	public double calcForceExertedBy(Body b) {
		double G = 6.67 * 1e-11;
		//double r = Math.pow(calcDistance(b), 2);
		double F = G * (myMass * b.getMass())/ Math.pow(calcDistance(b), 2);
		return F;
	}
	
	
	public double calcForceExertedByX(Body b) {
		double Fx = (calcForceExertedBy(b) * (b.getX()-myXPos))/ calcDistance(b);
		return Fx;
		
		
		
	}
	
	public double calcForceExertedByY(Body b) {
		double Fy = (calcForceExertedBy(b) * (b.getY()-myYPos))/ calcDistance(b);
		return Fy;
	}
	
	public double calcNetForceExertedByX(Body[] bodies) {
		double sum =0;
		for(Body b: bodies) {
			if(! b.equals(this)) {
				sum = sum + calcForceExertedByX(b);
								
			}
			 
		} 
		 return sum;

		
	}
	
	public double calcNetForceExertedByY(Body[] bodies) {
		double sum =0;
		for(Body b: bodies) {
			if(! b.equals(this)) {
				sum = sum + calcForceExertedByY(b);
								
			}
			 
		} 
		 return sum;

}
	public void update(double deltaT, double xforce,double yforce) {
		double ax =  xforce/myMass;
		double ay = yforce/myMass;
		
		double nvx = myXVel + deltaT * ax;
		double nvy = myYVel + deltaT * ay;
		
		double nx = myXPos + deltaT * nvx;
		double ny = myYPos + deltaT * nvy;
		
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;
		
		
	}
	public void draw() {
		StdDraw.picture(myXPos, myYPos, "images/"+myFileName);
	}
	
}
