package ds.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    List<Integer> list;
    MinHeap() {
        list = new ArrayList<>();
    }

    int size() {
        return this.list.size();
    }

    int getMin() {
        return list.get(0);
    }

    void insert(int x) {
        list.add(x);
        int s = size();
        int idx = s-1;
        while(idx > 0 && list.get(idx) < list.get((idx-1)/2)) {
            int tmp = list.get((idx-1)/2);
            list.set((idx-1)/2, x);
            list.set(idx, tmp);
            idx = (idx - 1) / 2;
        }
    }

    void delMin() {
        if(size() == 1) {
            list.clear();
            return;
        }
        final Integer x = list.remove((int) size() - 1);
        list.set(0, x);
        int s = size();

        int idx = 0;
        int c1Idx = 2*idx+1;
        int c2Idx = 2*idx+2;
        while(idx < s && (c1Idx < s || c2Idx < s)) {
            if(c1Idx < s && list.get(idx) <= list.get(c1Idx)
                    && c2Idx < s && list.get(idx) <= list.get(c2Idx)) {
                break;
            } else if(c1Idx >= s && c2Idx < s && list.get(idx) <= list.get(c2Idx)) {
                break;
            } else if(c2Idx >= s && c1Idx < s && list.get(idx) <= list.get(c1Idx)) {
                break;
            }
            if(c2Idx >= s || list.get(c1Idx) < list.get(c2Idx)) {
                int tmp = list.get(c1Idx);
                list.set(c1Idx, x);
                list.set(idx, tmp);
                idx = c1Idx;
            } else {
                int tmp = list.get(c2Idx);
                list.set(c2Idx, x);
                list.set(idx, tmp);
                idx = c2Idx;
            }
            c1Idx = 2*idx+1;
            c2Idx = 2*idx+2;
        }
    }

    private static void solve(List<String> queries) {
        StringBuilder builder = new StringBuilder();
        MinHeap mh = new MinHeap();
        for(String q : queries) {
            final String[] qarr = q.split(" ");
            switch (qarr[0]) {
                case "insert":
                    mh.insert(Integer.parseInt(qarr[1]));
                    break;
                case "getMin":
                    if(mh.size() == 0) {
                        builder.append("Empty").append(System.lineSeparator());
                    } else {
                        builder.append(mh.getMin()).append(System.lineSeparator());
                    }
                    break;
                case "delMin":
                    if(mh.size() != 0) {
                        mh.delMin();
                    }
                    break;
            }
        }
        System.out.println(builder);
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            List<String> queries = new ArrayList<>();
            for(int i = 0; i < t; i++) {
                queries.add(br.readLine());
            }
            solve(queries);
        }
    }
}
