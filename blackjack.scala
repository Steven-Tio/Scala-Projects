//to run type in terminal, scala blackjack.scala
import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source
import scala.util.Random 

object ScalaTutorial {
    def main(args: Array[String]): Unit = { 
        println(" ")
        println("One deck of cards is used.")
        println(" ")
        var cards = 51
        var userScore = 0
        var dealerScore = 0
        var userHighScore = 0
        var dealerHighScore = 0
        var userAce = 0
        var dealerAce = 0
        val r = scala.util.Random
        var num = r.nextInt(cards)
        cards -= 1
        val favNums = ArrayBuffer(1,2,3,4,5,6,7,8,9,10,10,10,10,1,2,3,4,5,6,7,8,9,10,10,10,10,1,2,3,4,5,6,7,8,9,10,10,10,10,1,2,3,4,5,6,7,8,9,10,10,10,10)

        println("Your cards")
        var score = favNums(num)
        if((score!=1)){
        println(score)
        userHighScore += score
        }
        else {
            println("Ace")
            userHighScore += 11
            userAce +=1
        }
        favNums.remove(num)
        userScore += score

        var num2 = r.nextInt(cards)
        cards -= 1
        favNums.remove(num2)
        num = r.nextInt(cards)
        cards -= 1
        score = favNums(num)
        if((score!=1)){
        println(score)
        userHighScore += score
        }
        else {
            println("Ace")
            if(userAce>0){
                userHighScore += 1
            }
            else{
                userHighScore += 11
                userAce +=1
            }
        
        }
        userScore += score
        if((userHighScore!=userScore) && (userHighScore<=21)){
            println("Your total: " + userScore + " or " + userHighScore)
        }
        else{
            println("Your total: " + userScore)
        }

        println(" ")
        println ("Dealer's Cards")
        var score2 = favNums(num2)
        if((score2!=1)){
            println(score2)
            dealerHighScore += score2
        }
        else {
            println("Ace")
            dealerHighScore += 11
            dealerAce +=1
        }
        
        dealerScore += score2
        num = r.nextInt(cards)
        cards -= 1
        var hidden = favNums(num)
        
        println("facedown")
        if((hidden!=1)){
        dealerHighScore += hidden
        }
        else {
            if(dealerAce>0){
                dealerHighScore +=1
            }
            else {
                dealerHighScore += 11
                dealerAce +=1
            }
        }
        favNums.remove(num)
        dealerScore += hidden

        println(" ")
        println("hit or stand")
        println(" ")
        var i = 0
        while(i == 0){
            var choice = readLine.toString
            if(choice.equals("hit")){
                println(" ")
                println("You hit")
                num = r.nextInt(cards)
                cards -= 1
                score = favNums(num)
                if((score!=1)){
                println(score)
                userHighScore += score
                }
                else {
                    println("Ace")
                    if(userAce>0){
                        userHighScore += 1
                    }
                    else{
                        userHighScore += 11
                        userAce +=1
                    }
                
                }
                favNums.remove(num)
                userScore +=score
                if((userHighScore!=userScore) && (userHighScore<=21)){
                    println("Your total: " + userScore + " or " + userHighScore)
                }
                else{
                    println("Your total: " + userScore)
                }
                println(" ")
                if(userScore>21){
                    println("You bust")
                    println(" ")
                    i=1
                }
                else{
                    println("hit or stand")
                }
            }
            if(choice.equals("stand")){
                println(" ")
                println("You stand")
                i=1
                println(" ")
            }
            if(!(choice.equals("stand")||choice.equals("hit"))){
                println("Invalid response, try again.")
                println(" ")
            }
        }
        if((score2==1) && (hidden==1)){
            println("The dealer had two aces")
        }
        else if(score2==1){
            println("The dealer had an ace and " + hidden)
        }
        else if(hidden==1){
            println("The dealer had a " + score2 + " and an ace")
        }
        else{
            println("The dealer had a " + score2 + " and " + hidden)
        }
        println(" ")
        if((dealerHighScore>=17) && (dealerHighScore<=21))
        {
            dealerScore = dealerHighScore
        }
        while(dealerScore<=16){
            num = r.nextInt(cards)
            cards -= 1
            score = favNums(num)
            if((score!=1)){
            println(score)
            dealerHighScore += score
            }
            else {
                println("Ace")
                if(dealerAce>0){
                    dealerHighScore += 1
                }
                else{
                    dealerHighScore += 11
                    dealerAce +=1
                }
            
            }
            favNums.remove(num)
            dealerScore += score
            println(" ")
        }
            if((dealerHighScore>=17) && (dealerHighScore<=21))
        {
            dealerScore = dealerHighScore
        }
        
        if((userHighScore>userScore) && (userHighScore<=21)){
            userScore=userHighScore
        }
            
        println("Your total: " + userScore)
        println("Dealer's total: " + dealerScore)
        if(userScore>21){
            println("You lose!")
        }
        else if(dealerScore>21){
            println("You win!")
        }
        else if(userScore == dealerScore){
            println("You tied!")
        }
        else if(userScore > dealerScore){
            println("You win!")
        }
        else{
            println("You lose!")
        }
    
    }
}
