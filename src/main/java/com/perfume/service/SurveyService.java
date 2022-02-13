package com.perfume.service;

import com.perfume.beans.PerfumeDTO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.perfume.beans.AbsSurveyDTO;
import com.perfume.beans.NoteDTO;

public interface SurveyService {

	public List<String> SurveyNoteNumCheck(NoteDTO ndto);
	
	public List<PerfumeDTO> SurveyAccNoteResult(List<String> list);
	
	public List<PerfumeDTO> SurveyBrandSearch(List<String> list);
	
	public List<AbsSurveyDTO> SurveyAbsSurvey1();
	
	public List<AbsSurveyDTO> SurveyAbsSurvey2();
	
	public List<AbsSurveyDTO> SurveyAbsSurvey3();
	
	public List<AbsSurveyDTO> SurveyAbsSurvey4(String third);
	
	public List<AbsSurveyDTO> SurveyAbsSurvey5(String fourth);
	
	public List<AbsSurveyDTO> SurveyAbsSurveyResult1(String gender);
	
	public List<AbsSurveyDTO> SurveyAbsSurveyResult2(String season);
	
	public List<AbsSurveyDTO> SurveyAbsSurveyResult3(String third);
	
	public List<AbsSurveyDTO> SurveyAbsSurveyResult4(String fourth);
	
	public List<AbsSurveyDTO> SurveyAbsSurveyResult5(String fifth);
	
	public List<String> SurveyAbsNoteNumCheck(List<String> list);
	
	public List<PerfumeDTO> SurveyAbsNoteResult(List<String> list);
	
	public int SurveyGetPerfumeCount(List<String> list);
	
	public List<PerfumeDTO> SurveyGetPerfumes (String[] n_number, int startRow, int endRow);

}
