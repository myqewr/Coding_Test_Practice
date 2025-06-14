SELECT a.APNT_NO, p.PT_NAME,p.PT_NO, a.MCDP_CD,d.DR_NAME, a.APNT_YMD 
FROM
    APPOINTMENT a
    INNER JOIN DOCTOR d ON a.MDDR_ID = d.DR_ID
    INNER JOIN PATIENT p ON a.PT_NO = p.PT_NO
where a.MCDP_CD = 'CS' AND YEAR(a.APNT_YMD) = 2022 AND MONTH(a.APNT_YMD)=4 AND DAY(a.APNT_YMD) = 13 AND a.APNT_CNCL_YN ='N' order by a.APNT_YMD;