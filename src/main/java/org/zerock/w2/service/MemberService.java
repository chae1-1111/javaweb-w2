package org.zerock.w2.service;

import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.MemberDAO;
import org.zerock.w2.domain.MemberVO;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.util.MapperUtil;

public enum MemberService {

    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login (String userid, String userpw) throws Exception {

        MemberVO memberVO = dao.getWithPassword(userid, userpw);

        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);

        return memberDTO;
    }

    public void updateUuid (String userid, String uuid) throws Exception {
        dao.updateUuid(userid, uuid);
    }

    public MemberDTO getByUUID(String uuid) throws Exception {
        MemberVO memberVO = dao.selectUUID(uuid);

        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);

        return memberDTO;
    }
}
