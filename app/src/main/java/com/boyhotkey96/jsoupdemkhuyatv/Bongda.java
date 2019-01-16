package com.boyhotkey96.jsoupdemkhuyatv;

import android.widget.ImageView;

public class Bongda {

    private String link;
    private String imgDoi1;
    private String imgDoi2;
    private String gio;
    private String ngay;
    private String phi;
    private String tentran;
    private String giaidau;

    public Bongda(String link, String imgDoi1, String imgDoi2, String gio, String ngay, String phi, String tentran, String giaidau) {
        this.link = link;
        this.imgDoi1 = imgDoi1;
        this.imgDoi2 = imgDoi2;
        this.gio = gio;
        this.ngay = ngay;
        this.phi = phi;
        this.tentran = tentran;
        this.giaidau = giaidau;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImgDoi1() {
        return imgDoi1;
    }

    public void setImgDoi1(String imgDoi1) {
        this.imgDoi1 = imgDoi1;
    }

    public String getImgDoi2() {
        return imgDoi2;
    }

    public void setImgDoi2(String imgDoi2) {
        this.imgDoi2 = imgDoi2;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getPhi() {
        return phi;
    }

    public void setPhi(String phi) {
        this.phi = phi;
    }

    public String getTentran() {
        return tentran;
    }

    public void setTentran(String tentran) {
        this.tentran = tentran;
    }

    public String getGiaidau() {
        return giaidau;
    }

    public void setGiaidau(String giaidau) {
        this.giaidau = giaidau;
    }
}
