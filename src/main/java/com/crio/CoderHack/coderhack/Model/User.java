package com.crio.CoderHack.coderhack.Model;


import com.crio.CoderHack.coderhack.DTO.Badges;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

   @Id
   BigInteger userID;
   String Username;
   int  Score;
   Badges badges;




}
