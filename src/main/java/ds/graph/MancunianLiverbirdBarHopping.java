package ds.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.stream.Stream;

public class MancunianLiverbirdBarHopping {

    static void solve(int n, int[] arr, String[] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reverseGraph = new ArrayList<>();
        graph.add(null);
        reverseGraph.add(null);
        for(int i = 1; i <=n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        int v = 1;
        for(int i : arr) {
            if(i == 1) {
                graph.get(v).add(v+1);
                reverseGraph.get(v+1).add(v);
            } else {
                graph.get(v+1).add(v);
                reverseGraph.get(v).add(v+1);
            }
            v++;
        }
        boolean isReversed = false;
        for(String query : queries) {
            String[] qarr = query.split(" ");
            if(qarr[0].equals("U")) {
                isReversed = !isReversed;
            } else {
                List<List<Integer>> g = isReversed ? reverseGraph : graph;
                int node = Integer.parseInt(qarr[1]);
                int count = 0;
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(node);
                while(queue.size() > 0) {
                    int b = queue.poll();
                    g.get(b).stream().forEach(e -> queue.add(e));
                    count++;
                }
                System.out.println(count);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int q = Integer.parseInt(br.readLine());
        String[] queries = new String[q];
        for(int i = 0; i < q; i++) {
            queries[i] = br.readLine();
        }
        br.close();
        solve(n, arr, queries);
    }
}
/*
    public static void main(String args[]) throws Exception {

        InputReader in = new InputReader(System.in);
        PrintWriter out  = new PrintWriter(System.out);
        int n = in.nextInt();
        int count  = 1;
        int count2 = 1;
        int flag=0;
        int a[] = new int[n+1];
        int b[] = new int[n+1];
        int b2[] = new int[n+1];
        for(int i = 1; i<n; i++){
            a[i] = in.nextInt();
            if(a[i] == 1){
                flag=1;
                count=1;
                //count2=1;
            }
            else{
                flag=0;
                count2=1;
            }
            if(a[i] == 0 && flag==0){
                b[i+1]=count+b[i+1];
                //b2[i]=count2+b2[i];
                count++;
                //count2++;
            }
            if(a[i]==1 && flag==1){
                b2[i+1]=count2+b2[i+1];
                count2++;
            }
        }
        count = 1;
        count2 = 1;
        for(int i = n-1; i>=1 ; i--){
            if(a[i] == 0){
                flag =0;
                count=1;
            }else{
                flag=1;
                count2=1;
            }
            if(flag==1 && a[i]==1){
                b[i]=count+b[i];
                count++;
            }
            if(flag==0 && a[i]==0){
                b2[i] = count2+b2[i];
                count2++;
            }
        }

        int q = in.nextInt();
        flag=0;
        for(int i=1;i<=q;i++){
            String query = in.readString();
            if(query.charAt(0) == 'Q'){
                int z = in.nextInt();
                if(flag==0) {
                    out.println(b[z]+1);
                }
                else{
                    out.println(b2[z]+1);
                }
            }else{
                if(flag==0){
                    flag=1;
                }else{
                    flag=0;
                }
            }
        }
        out.close();
 */
/*
#include<bits/stdc++.h>
using namespace std;
#define ll long long int

ll edges[1000005];
ll left1[1000005],right1[1000005],left2[1000005],right2[1000005];
int main(){
    ll n,x,q;
    cin>>n;
    for(ll i=1;i<=n-1;i++){
      cin>>edges[i];
    }

    left1[1]=0;
    for(ll i=2;i<=n;i++){
      if(edges[i-1]==0){
        left1[i]=1+left1[i-1];
      }else{
        left1[i]=0;
      }
    }

    right1[n]=0;
    for(ll i=n-1;i>=1;i--){
      if(edges[i]==1){
        right1[i]=1+right1[i+1];
      }else{
        right1[i]=0;
      }
    }
    for(ll i=1;i<=n-1;i++){
      edges[i]=edges[i]^1;
    }

    left2[1]=0;
    for(ll i=2;i<=n;i++){
      if(edges[i-1]==0){
        left2[i]=1+left2[i-1];
      }else{
        left2[i]=0;
      }
    }

    right2[n]=0;
    for(ll i=n-1;i>=1;i--){
      if(edges[i]==1){
        right2[i]=1+right2[i+1];
      }else{
        right2[i]=0;
      }
    }

    for(ll i=1;i<=n;i++){
      left1[i]+=right1[i];
      left2[i]+=right2[i];
    }
    ll flag=1;
    char ch;
    cin>>q;
    while(q--){
      cin>>ch;
      if(ch=='Q'){
        cin>>x;
        if(flag)cout<<left1[x]+1<<endl;
        else cout<<left2[x]+1<<endl;
      }else{
        flag=1^flag;
      }
    }
    return 0;
}
 */
