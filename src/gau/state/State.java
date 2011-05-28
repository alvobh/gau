package gau.state;

import gau.models.RealTeam;

import java.util.ArrayList;

public final class State {
   
   private static boolean test;
   private static ArrayList<RealTeam> teams;

   private State() {
   }
   
   public static boolean isTest() {
      return test;
   }

   public static void init(String env) throws Exception{
      setEnv(env);
      setTeams(env);
   }

   public static void setTeams(String env) throws Exception{
      teams = Adaptor.getTeams();
   }

   public static void setEnv(String env){
      if (env.equals("test")) {
         test = true;
      } else {
         test = false;
      }
   }
   
   public static ArrayList<RealTeam> getTeams() {
      return teams;
   }

}
