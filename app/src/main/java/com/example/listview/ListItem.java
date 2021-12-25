package com.example.listview;

public class ListItem {
    private String _name;
    private String _description;
    ListItem(String name,String description){
        _name=name;
        _description=description;
    }
    public void set_name(String name){
        _name=name;
    }
    public void set_description(String description){
        _description=description;
    }
    public String get_name(){
        return _name;
    }
    public String get_description(){
        return _description;
    }
}
