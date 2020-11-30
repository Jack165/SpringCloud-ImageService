package com.feng.image.util.picture;


import java.awt.image.BufferedImage;

public class BitmapOutput {
	private BufferedImage _bmp;
	private int curX, curY, iRGB;
	private int bitsLeft;
	private int r, g, b;

	public BitmapOutput(BufferedImage bmp) {
		this._bmp = bmp;
		curX = curY = iRGB = 0;
		bitsLeft = (bmp.getHeight() * bmp.getWidth() * 3);
	}

	public BufferedImage getBufferedImage() {
		return _bmp;
	}

	public synchronized boolean writeByte(int body) {
		if (bitsLeft < 8)
			return false;
		int bits2Do = 8;
		for (; curX < _bmp.getWidth(); curX++) {
			if (curY >= _bmp.getHeight()) {
				curY = 0;
			}
			for (; curY < _bmp.getHeight(); curY++) {
				if (bits2Do == 0)
					return true;
				int rgb = _bmp.getRGB(curX, curY);
//转化为r,g,b格式

				r = (rgb & 0x00ff0000) >> 16;
				g = (rgb & 0x0000ff00) >> 8;
				b = (rgb & 0x000000ff);
				while (true) {
					int curBit = (body & 1);
					switch (iRGB) {
					case 0:
						r = (r & 0xFE);
						r |= curBit;
						break;
					case 1:
						g = (g & 0xFE);
						g |= curBit;
						break;
					case 2:
						b = (b & 0xFE);
						b |= curBit;
						break;
					}
					--bits2Do;
					--bitsLeft;
					body >>= 1;
//还原

					rgb = (r << 16) | (g << 8) | b;
//重新注入

					_bmp.setRGB(curX, curY, rgb);
					if (iRGB == 2) {
						iRGB = 0;
						break;
					}
					iRGB++;
					if (bits2Do == 0)
						return true;
				}
			}
		}
		return true;
	}
}