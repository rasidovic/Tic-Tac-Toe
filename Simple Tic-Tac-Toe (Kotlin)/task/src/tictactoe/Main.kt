package tictactoe

fun main() {
    var string: String = "         "
    var counter = 0

    while (true) {
        counter++
        var xoro: String = if (counter % 2 == 0){
            "O"
        } else "X"
        val (row, col) = readLine()!!.split(" ").map(String::toInt)

        if (row !in 1..3 || col !in 1..3) {
            println("Coordinates should be from 1 to 3!")
            continue
        }

        val index = (row - 1) * 3 + col - 1
        if (string[index] != ' ' && string[index] != '_') {
            println("This cell is occupied! Choose another one!")
            continue
        }

        string = string.substring(0, index) + xoro + string.substring(index + 1)

        println("""
---------
| ${string[0]} ${string[1]} ${string[2]} |
| ${string[3]} ${string[4]} ${string[5]} |
| ${string[6]} ${string[7]} ${string[8]} |
--------- 
    """)
        val firstRowX = (string[0] == 'X' && string[1] == 'X' && string[2] == 'X')
        val secondRowX = (string[3] == 'X' && string[4] == 'X' && string[5] == 'X')
        val thirdRowX = (string[6] == 'X' && string[7] == 'X' && string[8] == 'X')
        val firstDiagonalX = (string[0] == 'X' && string[4] == 'X' && string[8] == 'X')
        val secondDiagonalX = (string[2] == 'X' && string[4] == 'X' && string[6] == 'X')
        val firstColumnX = (string[0] == 'X' && string[3] == 'X' && string[6] == 'X')
        val secondColumnX = (string[1] == 'X' && string[4] == 'X' && string[7] == 'X')
        val thirdColumnX = (string[2] == 'X' && string[5] == 'X' && string[8] == 'X')

        val firstRowO = (string[0] == 'O' && string[1] == 'O' && string[2] == 'O')
        val secondRowO = (string[3] == 'O' && string[4] == 'O' && string[5] == 'O')
        val thirdRowO = (string[6] == 'O' && string[7] == 'O' && string[8] == 'O')
        val firstDiagonalO = (string[0] == 'O' && string[4] == 'O' && string[8] == 'O')
        val secondDiagonalO = (string[2] == 'O' && string[4] == 'O' && string[6] == 'O')
        val firstColumnO = (string[0] == 'O' && string[3] == 'O' && string[6] == 'O')
        val secondColumnO = (string[1] == 'O' && string[4] == 'O' && string[7] == 'O')
        val thirdColumnO = (string[2] == 'O' && string[5] == 'O' && string[8] == 'O')

        val xWins = firstColumnX || secondColumnX || thirdColumnX || firstRowX || secondRowX || thirdRowX || firstDiagonalX || secondDiagonalX
        val oWins = firstColumnO || secondColumnO || thirdColumnO || firstRowO || secondRowO || thirdRowO || firstDiagonalO || secondDiagonalO

        val xCount = string.count{ it == 'X' }
        val oCount = string.count{ it == 'O' }
        var emptySpaces = string.count{ it == ' '}

        if (xWins) {
            println("X wins")
            break
        } else if(oWins){
            println("O wins")
            break
        } else if(emptySpaces == 0) {
            println("Draw")
            break
        }
    }
}