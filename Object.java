import java.awt.Dimension;
import javax.swing.*;

public abstract class Object{

    protected double position_x;
	protected double position_y;
	protected String direction;

    public double get_x(){
        return position_x;
    }

	public double get_y(){
        return position_y;
    }

	public String get_dir(){
        return direction;
    }	

	public void set_x(double x){
        position_x = x;
    }
	public void set_y(double y){
        position_y = y;
    }

    public void set_dir(String dir){
        direction = dir;
    }
    
    // public abstract void draw();
}