package com.zrtg.mittoolcorebluecloudapi.utils;


import com.zrtg.mittoolcorebluecloudapi.model.dto.s6v2.*;

import java.util.ArrayList;
import java.util.List;

public class S6v2Utils {


    public S6V2 getEntity(S6v2DTO s6v2DTO) {
        S6V2 s6V2 = new S6V2();
        s6V2.setHead(getHead(s6v2DTO));
        s6V2.setContentInfo(getContentInfo(s6v2DTO));
        return s6V2;
    }

    private SHead getHead(S6v2DTO s6v2DTO) {
        SHead sHead = new SHead();
        sHead.setTaskGUID(s6v2DTO.getGuid());
        sHead.setTaskName(s6v2DTO.getTaskName());
        return sHead;
    }

    private SContentInfo getContentInfo(S6v2DTO s6v2DTO) {
        SContentInfo sContentInfo = new SContentInfo();
        sContentInfo.setTypeID(s6v2DTO.getTypeId());
        sContentInfo.setTypeName(s6v2DTO.getTypeName());
        sContentInfo.setContentID(s6v2DTO.getGuid());
        sContentInfo.setContentData(getContentData(s6v2DTO));
        return sContentInfo;
    }

    private SContentData getContentData(S6v2DTO s6v2DTO) {
        SContentData sContentData = new SContentData();
        sContentData.setContentFile(getContentFile(s6v2DTO));
        getEntityData(s6v2DTO);
        sContentData.setEntityData(getEntityData(s6v2DTO));
        return sContentData;
    }

    private SContentFile getContentFile(S6v2DTO s6v2DTO) {
        SContentFile sContentFile = new SContentFile();
        sContentFile.setFileItem(getFileItems(s6v2DTO));
        return sContentFile;
    }


    private List<SFileItem> getFileItems(S6v2DTO s6v2DTO) {
        List<SFileItem> resp = new ArrayList<>();
        SFileItem sFileItem = new SFileItem();
        sFileItem.setFileGUID(s6v2DTO.getGuid());
        sFileItem.setFileSize(s6v2DTO.getFileSize());
        sFileItem.setFileName(getFileName(s6v2DTO));
        resp.add(sFileItem);
        return resp;
    }

    private SFileName getFileName(S6v2DTO s6v2DTO) {
        SFileName sFileName = new SFileName();
        sFileName.setFullPath(s6v2DTO.getFullPath());
        return sFileName;
    }

    private List<SEntityData> getEntityData(S6v2DTO s6v2DTO) {
        List<SEntityData> resp = new ArrayList<>();

        resp.add(SEntityData.builder()
                .itemCode("type")
                .value(s6v2DTO.getEntityTypeValue())
                .build());

        resp.add(SEntityData.builder()
                .itemCode("name")
                .value(s6v2DTO.getTaskName())
                .build());

        resp.add(SEntityData.builder()
                .itemCode("editors")
                .value(s6v2DTO.getAuthor())
                .build());

        resp.add(SEntityData.builder()
                .itemCode("editor")
                .value(s6v2DTO.getAuthor())
                .build());

        resp.add(SEntityData.builder()
                .itemCode("ClipName")
                .value(s6v2DTO.getClipName())
                .build());
        return resp;
    }

}
