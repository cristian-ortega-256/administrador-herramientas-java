package view;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;

class TextBubbleBorder extends AbstractBorder
{
	private static final long serialVersionUID = 1L;
	private Color color;
	private int thickness;
	

	private int radius;
	private int pointerSize = 0;
	private Insets insets = null;
	private BasicStroke stroke = null;
	private int strokePad;
	private double pointerPadPercent = 0.5;
	int pointerSide = SwingConstants.TOP;
	RenderingHints hints;

	TextBubbleBorder(Color color)
	{
		this(color, 2, 4, 0);
	}

	TextBubbleBorder(Color color, int thickness, int radius, int pointerSize)
	{
		this.color = color;
		this.thickness = thickness;
		this.radius = radius;
		this.pointerSize = pointerSize;
		
		hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		insets = new Insets(0, 0, 0, 0);
		
		setThickness(thickness);
	}



	// {{ Setter/Getter
	public Color getColor()
	{
		return color;
	}

	public TextBubbleBorder setColor(Color color)
	{
		this.color = color;
		return this;
	}

	public double getPointerPadPercent()
	{
		return pointerPadPercent;
	}

	public TextBubbleBorder setPointerPadPercent(double percent)
	{
		this.pointerPadPercent = percent > 1? 1: percent;
		pointerPadPercent = pointerPadPercent < 0? 0: pointerPadPercent;
		return this;
	}

	public int getThickness()
	{
		return thickness;
	}

	public int getRadius()
	{
		return radius;
	}

	public int getPointerSize()
	{
		return pointerSize;
	}
	public TextBubbleBorder setThickness(int n)
	{
		thickness = n < 0? 0: n;

		stroke = new BasicStroke(thickness);
		strokePad = thickness / 2;
		
		setPointerSize(pointerSize);
		return this;
	}
	public TextBubbleBorder setPointerSize(int size)
	{
		pointerSize = size < 0 ? 0: size;
		// 这里需要 radii/2 不然会有多出来的边距
		int pad = radius/2 + strokePad;
		
		int pointerSidePad = pad + pointerSize + strokePad;
		// 根据不同的方向设置不同的Padding
		int left, right, bottom, top;
		left = right = bottom = top = pad;
		switch (pointerSide)
		{
			case SwingConstants.TOP:
				top = pointerSidePad;
				break;
			case SwingConstants.LEFT:
				left = pointerSidePad;
				break;
			case SwingConstants.RIGHT:
				right = pointerSidePad;
				break;
			default:
			case SwingConstants.BOTTOM:
				bottom = pointerSidePad;
			break;
		}
		insets.set(top, left, bottom, right);
		return this;
	}
	public int getPointerSide()
	{
		return pointerSide;
	}

	public TextBubbleBorder setPointerSide(int pointerSide)
	{
		this.pointerSide = pointerSide;
		setPointerSize(pointerSize);
		return this;
	}

	public TextBubbleBorder setRadius(int radius)
	{
		this.radius = radius;
		setPointerSize(pointerSize);
		return this;
	}
	
	// }}
	
	@Override
	public Insets getBorderInsets(Component c)
	{
		return insets;
	}

	@Override
	public Insets getBorderInsets(Component c, Insets insets)
	{
		return getBorderInsets(c);
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
	{
		Graphics2D g2 = (Graphics2D) g;
		// 修正背景色的问题
		g2.setBackground(c.getBackground());
		
		int bottomLineY = height - thickness - pointerSize;

		RoundRectangle2D.Double bubble;
		Polygon pointer = new Polygon();
		
		// 初始范围
		{
			// 设置圆角矩形
			int rx, ry, rw, rh;
			rx = ry = strokePad;
			rw = width - thickness;
			rh = height - thickness;
			
			
			switch (pointerSide)
			{
				case SwingConstants.LEFT:
					rx += pointerSize;
				case SwingConstants.RIGHT:
					rw -= pointerSize;
					break;
					
				case SwingConstants.TOP:
					ry += pointerSize;
				case SwingConstants.BOTTOM:
				default:
					rh -= pointerSize;
				break;
			}
			
			bubble = new RoundRectangle2D.Double(rx,ry,rw,rh,radius, radius);
			
			// 计算偏移
			int pointerPad;
			
			if (pointerSide == SwingConstants.LEFT || pointerSide == SwingConstants.RIGHT)
			{
				pointerPad = (int) (pointerPadPercent * (height-radius*2-pointerSize));
			}else {
				pointerPad = (int) (pointerPadPercent * (width-radius*2-pointerSize));
			}

			// 设置三角
			int basePad = strokePad + radius + pointerPad;
			
			switch (pointerSide)
			{

				case SwingConstants.LEFT:
					pointer.addPoint(rx, basePad);// top
					pointer.addPoint(rx, basePad+pointerSize);// bottom
					pointer.addPoint(strokePad, basePad+pointerSize/2);
					break;
				case SwingConstants.RIGHT:
					pointer.addPoint(rw, basePad);// top
					pointer.addPoint(rw, basePad+pointerSize);// bottom
					pointer.addPoint(width-strokePad, basePad+pointerSize/2);
					break;
					
				case SwingConstants.TOP:
					pointer.addPoint(basePad, ry);// left
					pointer.addPoint(basePad + pointerSize, ry);// right
					pointer.addPoint(basePad + (pointerSize / 2), strokePad);
					break;
				default:
				case SwingConstants.BOTTOM:
					pointer.addPoint(basePad, rh);// left
					pointer.addPoint(basePad + pointerSize, rh);// right
					pointer.addPoint(basePad + (pointerSize / 2), height - strokePad);
				break;
			}			
		}
		
		Area area = new Area(bubble);
		area.add(new Area(pointer));

		g2.setRenderingHints(hints);

		Area spareSpace = new Area(new Rectangle(0, 0, width, height));
		spareSpace.subtract(area);
		g2.setClip(spareSpace);
		g2.clearRect(0, 0, width, height);
		
		g2.setClip(null);

		g2.setColor(color);
		g2.setStroke(stroke);
		g2.draw(area);
	}
}
