package utils;

import bean.Video;

import java.util.Arrays;
import java.util.List;

/**
 * 此类用于计算视频相似度相似度
 */
public class SimCal {
    public static int[][] fenqu = {{1, 24, 25, 47, 210, 86, 253, 27}, {13, 51, 152, 32, 33}, {167, 153, 168, 169, 170, 195}, {3, 28, 31, 30, 59, 193, 29, 130, 243, 244}, {129, 20, 154, 156, 198, 199, 200}, {4, 17, 171, 178, 65, 173, 121, 136, 19}, {36, 201, 124, 228, 207, 208, 209, 229, 122}, {188, 95, 230, 231, 232, 233}, {234, 235, 249, 164, 236, 237, 238}, {223, 245, 246, 247, 248, 240, 227, 176}, {160, 138, 250, 251, 239, 161, 162, 21}, {211, 76, 212, 213, 214, 215}, {217, 218, 219, 220, 221, 222, 75}, {119, 22, 26, 126, 216, 127}, {155, 157, 252, 158, 159}, {5, 71, 241, 242, 137}, {181, 182, 183, 85, 184}};


    public static double VideoSimCal(Video video1, Video video2) {
        double tidSimnum = tidSim(video1,video2);
        float A = ((video1.view >> 10) * (video2.view >> 10) +(video1.danmaku >> 5)* (video2.danmaku>> 5) + (video1.coin>> 5) * (video2.coin>> 5) + (video1.favorite>> 5) * (video2.favorite >> 5)+ (video1.reply>> 5)* (video2.reply>> 5) + (video1.share>> 5)* (video2.share>> 5) + (video1.dianzan>> 5)* (video2.dianzan>> 5) + (video1.duration >> 5)* (video2.duration>> 5));
        double B = Math.sqrt(((video1.view >> 10) * (video1.view >> 10) +(video1.danmaku >> 5)* (video1.danmaku>> 5) + (video1.coin>> 5) * (video1.coin>> 5) + (video1.favorite>> 5) * (video1.favorite >> 5)+ (video1.reply>> 5)* (video1.reply>> 5) + (video1.share>> 5)* (video1.share>> 5) + (video1.dianzan>> 5)* (video1.dianzan>> 5) + (video1.duration >> 5)* (video1.duration>> 5)));
        double C = Math.sqrt((video2.view >> 10) * (video2.view >> 10) +(video2.danmaku >> 5)* (video2.danmaku>> 5) + (video2.coin>> 5) * (video2.coin>> 5) + (video2.favorite>> 5) * (video2.favorite >> 5)+ (video2.reply>> 5)* (video2.reply>> 5) + (video2.share>> 5)* (video2.share>> 5) + (video2.dianzan>> 5)* (video2.dianzan>> 5) + (video2.duration >> 5)* (video2.duration>> 5));
        float sim = (float) (A / (B* C) +tidSimnum);
        System.out.println(A + " " + B + " " + C);
        System.out.println(tidSimnum);
        return sim + tidSimnum;
    }
    public static double tidSim(Video video1,Video video2){
        int a = video1.tid;
        int b = video2.tid;
        if (a == b)
            return 2.0;
        boolean found = false;

        for (int[] row : fenqu) {
            boolean hasA = false;
            boolean hasB = false;
            for (int num : row) {
                if (num == a) {
                    hasA = true;
                }
                if (num == b) {
                    hasB = true;
                }
                if (hasA && hasB) {
                    found = true;
                    break;
                }
            }
        }
        if (found)
            return 1.0;
        else return 0.5;
    }
    public static void main(String[] args) {
//        VideoSimCal();
    }
}
