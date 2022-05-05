package com.hwxy.code.leetcode.order.l2100.l2039;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 2039. 网络空闲的时刻
 * https://leetcode-cn.com/problems/the-time-when-the-network-becomes-idle/
 * 
 * @author hwxy
 * @date 2022/03/20
 **/
public class Lc2039 {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        int[][] p1 = mapper.readValue(
                "[[34,90],[82,5],[184,178],[92,32],[125,98],[149,134],[120,154],[37,129],[30,180],[161,2],[116,20],[42,12],[62,73],[96,162],[174,31],[124,101],[43,82],[87,59],[127,137],[103,7],[58,14],[119,133],[1,15],[84,113],[164,122],[128,104],[141,36],[81,166],[170,182],[89,30],[85,84],[109,1],[28,70],[83,102],[117,60],[31,169],[159,76],[146,67],[151,58],[23,34],[148,184],[179,19],[123,115],[70,21],[78,33],[99,26],[155,71],[104,100],[16,151],[72,147],[95,124],[13,138],[133,53],[60,116],[173,63],[29,56],[80,120],[17,43],[55,110],[6,119],[154,143],[51,172],[14,39],[112,38],[39,32],[35,132],[98,159],[160,107],[73,65],[183,27],[177,78],[136,46],[18,75],[27,91],[71,163],[100,77],[122,51],[178,45],[52,55],[59,160],[12,114],[38,42],[113,4],[163,167],[171,131],[167,183],[7,37],[102,54],[91,156],[40,92],[139,74],[142,145],[147,62],[0,128],[66,165],[111,175],[107,16],[22,80],[92,53],[94,86],[153,24],[74,3],[165,108],[176,130],[181,177],[67,95],[144,117],[15,135],[57,93],[145,8],[8,48],[26,127],[36,171],[126,40],[168,157],[108,121],[56,109],[65,88],[169,35],[130,181],[110,9],[2,22],[137,87],[152,118],[182,174],[53,32],[79,10],[114,47],[63,161],[0,94],[0,32],[76,150],[131,112],[129,105],[121,168],[118,111],[68,83],[69,61],[5,173],[172,149],[20,179],[162,57],[21,158],[166,11],[105,139],[93,44],[97,79],[106,23],[47,123],[46,49],[77,50],[157,153],[138,126],[0,69],[88,97],[24,68],[156,176],[92,39],[48,41],[158,170],[86,146],[61,142],[54,125],[19,148],[175,52],[44,85],[9,103],[135,144],[33,152],[90,66],[140,6],[101,28],[143,136],[75,96],[41,155],[53,39],[115,140],[150,13],[134,72],[180,164],[64,81],[45,106],[49,141],[50,89],[4,99],[11,25],[10,64],[25,17],[3,18],[132,29]]",
                int[][].class);
        int[] p2 = mapper.readValue(
                "[0,5,4,6,8,6,10,3,11,1,9,1,9,13,9,9,12,3,6,7,2,5,1,4,7,4,18,10,7,9,16,1,24,1,5,15,5,8,11,2,27,4,10,1,3,4,3,8,1,10,12,21,3,2,17,1,1,1,5,3,4,29,11,2,4,2,9,9,12,9,2,10,9,7,5,7,9,3,10,2,7,4,8,3,12,4,16,6,4,22,6,13,20,1,2,8,1,2,5,16,29,16,5,1,27,2,5,22,1,6,4,5,7,5,15,5,4,5,4,6,8,5,8,24,23,17,7,8,3,1,7,5,2,17,4,5,11,9,16,1,12,13,26,1,7,4,18,1,7,12,19,12,1,10,3,3,14,8,15,19,22,1,4,22,14,1,4,1,11,11,13,2,2,1,1,7,8,2,2,1,15,3,4,19,1]",
                int[].class);
        System.out.println(
                new Lc2039().networkBecomesIdle(p1, p2));
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        if (edges == null || patience == null) {
            return 0;
        }
        // 求出到0的最短距离
        List<Integer>[] fromTos = new List[patience.length];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            List<Integer> fromTo = fromTos[from];
            if (fromTo == null) {
                fromTo = new ArrayList<>();
                fromTos[from] = fromTo;
            }
            fromTo.add(to);
            List<Integer> toFrom = fromTos[to];
            if (toFrom == null) {
                toFrom = new ArrayList<>();
                fromTos[to] = toFrom;
            }
            toFrom.add(from);
        }
        boolean[] visit = new boolean[patience.length];
        int[] toZeroStep = new int[patience.length];
        // 从0节点开始计算到0的最短距离
        calStep(toZeroStep, fromTos, visit);
        int res = 0;
        // 遍历出最晚的时间
        for (int i = 1; i < toZeroStep.length; i++) {
            // 最早接收到返回的时间是路径*2秒
            int receive = toZeroStep[i] * 2;
            // 重发时间如果>=收到时间则不会发送
            if (patience[i] >= receive) {
                res = Math.max(receive, res);
                continue;
            }
            // 否则会进行重发,计算重试次数,整除时的次数要注意,也可以写成(receive -1 / patience[i])
            int retryCnt =
                    receive % patience[i] == 0 ? receive / patience[i] - 1 : receive / patience[i];
            // 重试最晚接受时间为:
            int retryRec = patience[i] * retryCnt + receive;
            res = Math.max(res, retryRec);
        }
        return res + 1;
    }

    /**
     * bfs计算到0的最短路径*
     */
    private void calStep(int[] toZeroStep, List<Integer>[] fromTos, boolean[] visit) {
        Queue<Integer> fromQueue = new LinkedList<>();
        fromQueue.add(0);
        int dist = 1;
        while (!fromQueue.isEmpty()) {
            int nodeSize = fromQueue.size();
            // 把这一层的都poll处理
            for (int i = 0; i < nodeSize; i++) {
                int from = fromQueue.poll();
                for (int to : fromTos[from]) {
                    // 遍历过了就继续
                    if (visit[to]) {
                        continue;
                    }
                    toZeroStep[to] = dist;
                    visit[to] = true;
                    fromQueue.add(to);
                }
            }
            dist++;
        }
    }

}
