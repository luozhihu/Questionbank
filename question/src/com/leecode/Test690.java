package com.leecode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    Map<Integer,Integer> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        int n = employees.size();
        for(int i = 0;i < n;i++) map.put(employees.get(i).id,i);
        return dfs(employees,id);
    }
    int dfs(List<Employee> employees, int id){
        int ans = employees.get(map.get(id)).importance;
        for(int one : employees.get(map.get(id)).subordinates){
            ans += dfs(employees,one);
        }
        return ans;
    }
}
