package code;

import java.awt.Graphics2D;
import java.util.Random;

public class Map {
	public int[][]gamemap;
	private int insert;
	private int num;
	public void printmap(int[][] gamemap,int MAPSIZE){
		for(int i=0;i<MAPSIZE;i++){
			for(int j=0;j<MAPSIZE;j++){
				System.out.println(gamemap[i][j]);
			}
			//System.out.println();
		}
	}

	public int[][] gen(int MAPSIZE){
		int[][] gamemap = new int[MAPSIZE][MAPSIZE];
		int a = 0;
		Random rand = new Random();
		for(int x = 0;x<MAPSIZE;x++){
			for(int y=0;y<MAPSIZE;y++){
				num = rand.nextInt((100-0)+1)+0;
				if(num <= 70){
					insert = 1;
				}
				else if (num > 80){
					insert = 2;
				}
				else{
					insert = rand.nextInt((399-100)+1)+100;
				}
				gamemap[x][y] = insert;				
			}
		}
		return gamemap;
		//printmap(gamemap,MAPSIZE);
	}
	
	public void render(int MAPSIZE, int[][] gamemap,Graphics2D g){
		Crop crop = new Crop();
		for(int x=0;x<MAPSIZE;x++){
			for(int y=0;y<MAPSIZE;y++){
				int tile = gamemap[x][y];
				if(tile == 1){
					g.drawImage(crop.grass,x,y,500,500,null);
				}
				else if(tile ==2){
					g.drawImage(crop.mud, x, y, 500, 500, null);
				}
				else{
					g.drawImage(crop.scrap, x, y, 500, 500, null);
				}
			}
			//System.out.println();
		}
	}
}
