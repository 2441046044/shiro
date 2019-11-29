package com.qfedu.shiro.entity;

import java.util.List;

public class MenuInfo {

    private Integer menuId;
    private String menuName;
    private String url;

    //子菜单列表
    private List<MenuInfo> childMenus;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuInfo> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<MenuInfo> childMenus) {
        this.childMenus = childMenus;
    }

    public MenuInfo() {
    }

    public MenuInfo(Integer menuId, String menuName, String url, List<MenuInfo> childMenus) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.url = url;
        this.childMenus = childMenus;
    }
}
