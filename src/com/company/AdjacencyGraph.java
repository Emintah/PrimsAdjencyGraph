package com.company;

import java.util.ArrayList;

public class  AdjacencyGraph {
    ArrayList<Vertex> vertices;
    public AdjacencyGraph(){
        vertices=new ArrayList<Vertex>();
    }
    public void addVertex(Vertex v){
        vertices.add(v);
    }
    //tilføjer edge eller retunere med en fejlkode hvis paramtre ikke er mødt
    public void addEdge(Vertex from,Vertex to, Integer weight){
        if(!(vertices.contains(from) && vertices.contains(to)) ) {
            System.out.println(" com.company.Vertex not in graph");
            return;
        }
        Edge e=new Edge(from, to,weight);
    }

    public void MSTPrims(){
        int Distance;

    }

    public  void PrintGraph(){
        for (int i=0;i<vertices.size();i++)
        {
            System.out.println(" From com.company.Vertex: "+ vertices.get(i).name);
            Vertex currentfrom=vertices.get(i);
            for(int j=0; j<currentfrom.OutEdges.size();j++){
                Edge currentEdge=currentfrom.OutEdges.get(j);
                System.out.println(" To: "+ currentEdge.to.name + " weight: "+currentEdge.weight);
            }
            System.out.println(" ");
        }
    }
}

class Vertex implements Comparable<Vertex>{
    String name;
    ArrayList<Edge> OutEdges;
    Integer dist= Integer.MAX_VALUE;
    public Vertex(String id){
        name=id;
        OutEdges=new ArrayList<Edge>();
    }
    public void addOutEdge(Edge e) {
        OutEdges.add(e);
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.dist<o.dist)
            return -1;
        if (this.dist>o.dist)
            return 1;
        return 0;
    }
}

class Edge{
    Integer weight;
    Vertex from;
    Vertex to;
    public Edge(Vertex from, Vertex to, Integer cost){
        this.from=from;
        this.to=to;
        this.weight=cost;
        this.from.addOutEdge(this);
    }
}
