package com.example.examen_christiangaraicoa;

import java.util.List;

public class JsonResponse {
    private boolean status;
    private List<products> objects;

    public JsonResponse() {
    }

    public JsonResponse(boolean status, List<products> objects) {
        this.status = status;
        this.objects = objects;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<products> getObjects() {
        return objects;
    }

    public void setObjects(List<products> objects) {
        this.objects = objects;
    }


}
