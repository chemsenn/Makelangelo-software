package com.marginallyclever.voronoi;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class VoronoiCell implements Comparable<VoronoiCell> {
	public Point2D centroid = new Point2D.Double();
	public Rectangle2D region;
	public double weight;
	public double wx, wy;
	public int hits;
	
	@Override
	public int compareTo(VoronoiCell arg0) {
		double y1 = arg0.centroid.getY();
		double y0 = centroid.getY();
		int c = Double.compare(y0, y1);
		if( c == 0 ) {
			double x1 = arg0.centroid.getX();
			double x0 = centroid.getX();
			c = Double.compare(x0, x1);
		}
		return c;
	}
	
	public String toString() {
		return centroid.toString()+",w="+weight;
	}
	
	public void resetRegion() {
		region = null;
		weight=0;
		hits=0;
		wx=0;
		wy=0;
	}
	
	public void addPoint(double x,double y) {
		if(region==null) {
			region = new Rectangle2D.Double(x,y,0,0);
		} else {
			region.add(x,y);
		}
	}
}
