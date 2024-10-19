SELECT  A.TITLE
        , A.BOARD_ID
        , B.REPLY_ID
        , B.WRITER_ID
        , B.CONTENTS
        , TO_CHAR(B.CREATED_DATE, 'YYYY-MM-DD') AS CREATED_DATE
  FROM  USED_GOODS_BOARD  A
  JOIN  USED_GOODS_REPLY  B
    ON  A.BOARD_ID = B.BOARD_ID
where   TO_CHAR(A.CREATED_DATE,'YYYY-MM') = '2022-10'
 ORDER BY  B.CREATED_DATE ASC, A.TITLE ASC;