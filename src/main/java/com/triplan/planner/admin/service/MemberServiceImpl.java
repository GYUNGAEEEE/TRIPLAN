package com.triplan.planner.admin.service;

import com.triplan.planner.admin.domain.Member;
import com.triplan.planner.admin.dto.MemberDTO;
import com.triplan.planner.admin.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;



    @Override
    public List<MemberDTO> getMembers(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<Member> members = memberRepository.selectAll(offset, pageSize);
        return members.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public int getMemberCount() {
        return memberRepository.countMembers();
    }

    @Override
    public List<MemberDTO> searchMembers(String searchType, String searchQuery, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<Member> members = memberRepository.searchMembers(searchType, searchQuery, offset, pageSize);
        return members.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public int countSearchMembers(String searchType, String searchQuery) {
        return memberRepository.countSearchMembers(searchType, searchQuery);
    }

    private MemberDTO convertToDTO(Member member) {
        MemberDTO dto = new MemberDTO();
        dto.setMemId(member.getMemId());
        dto.setName(member.getName());
        dto.setNickName(member.getNickName());
        dto.setEmail(member.getEmail());
        dto.setGender(member.getGender());
        dto.setTel(member.getTel());
        dto.setGrade(member.getGrade());
        return dto;
    }

    @Override
    public void updateMemberGrade(String memId, int grade) {
        memberRepository.updateMemberGrade(memId, grade);
    }
}
