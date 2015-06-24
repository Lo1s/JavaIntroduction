/**
 * 
 */
package chapter13;

import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 * 7. 8. 2014
 * 21:02:19
 */
public class PE1327_StrategicPointPolygon extends JFrame
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1327_StrategicPointPolygon(Polygon p)
    {
        add(new DrawPolygonStrategicPoint(p));
    }

    public static void main(String args[])
    {
        if(args.length < 6 || args.length % 2 != 0)
        {
            System.out.println("Usage: java Exercise14_33 x1 y1 x2 y2 x3 y3 x4 y4 ... ");
            System.exit(1);
        }
        Polygon p = new Polygon();
        for(int i = 0; i < args.length; i += 2)
        {
            p.addPoint(Integer.parseInt(args[i]), Integer.parseInt(args[i + 1]));
        }

        PE1327_StrategicPointPolygon frame = new PE1327_StrategicPointPolygon(p);
        frame.setTitle("Exercise13_27");
        frame.setDefaultCloseOperation(3);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class DrawPolygonStrategicPoint extends JPanel
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Polygon p;

    DrawPolygonStrategicPoint(Polygon p)
    {
        this.p = p;
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int center[] = getCenter();
        g.drawPolygon(p);
        for(int i = 0; i < p.npoints; i++)
        {
            g.fillOval(p.xpoints[i] - 2, p.ypoints[i] - 2, 4, 4);
            g.drawString((new StringBuilder("(")).append(p.xpoints[i]).append(", ").append(p.ypoints[i]).append(")").toString(), p.xpoints[i] - 16, p.ypoints[i] - 6);
        }

        g.drawOval(center[0] - 2, center[1] - 2, 4, 4);
        g.drawString((new StringBuilder("(")).append(center[0]).append(", ").append(center[0]).append(")").toString(), center[0] - 16, center[1] - 6);
    }

    int[] getCenter()
    {
        int minX = min(p.xpoints);
        int maxX = max(p.xpoints);
        int minY = min(p.ypoints);
        int maxY = max(p.ypoints);
        int result[] = new int[2];
        double currentTotal = 1.7976931348623157E+308D;
        for(int i = minX; i <= maxX; i++)
        {
            for(int j = minY; j <= maxY; j++)
            {
                if(p.contains(i, j))
                {
                    double sum = 0.0D;
                    for(int k = 0; k < p.npoints; k++)
                    {
                        sum += distance(p.xpoints[k], p.ypoints[k], i, j);
                    }

                    if(currentTotal > sum)
                    {
                        result[0] = i;
                        result[1] = j;
                        currentTotal = sum;
                    }
                }
            }

        }

        return result;
    }

    private static double distance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    private static int min(int list[])
    {
        int result = list[0];
        for(int i = 1; i < list.length; i++)
        {
            if(result > list[i])
            {
                result = list[i];
            }
        }

        return result;
    }

    private static int max(int list[])
    {
        int result = list[0];
        for(int i = 1; i < list.length; i++)
        {
            if(result < list[i])
            {
                result = list[i];
            }
        }

        return result;
    }
}
