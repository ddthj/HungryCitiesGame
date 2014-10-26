package code;

import java.awt.image.BufferedImage;

public class Crop {
	public BufferedImage grass,mud,trees,scrap;
	private BufferedImage spritesheet;
	public void init(BufferedImage spritesheet){
		this.spritesheet = spritesheet;
		this.grass = crop(spritesheet,0,0,500,500);
		this.mud = crop(spritesheet,1,0,500,500);
		this.scrap = crop(spritesheet,2,0,500,500);		
	}
	private BufferedImage crop(BufferedImage spritesheet,int col,int row,int w,int h){
		BufferedImage result = spritesheet.getSubimage(col*120,row*120,w,h);
		return result;
	}

}
