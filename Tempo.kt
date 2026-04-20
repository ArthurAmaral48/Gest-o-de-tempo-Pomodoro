import javax.swing.JOptionPane

object PomodoroApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val nome = JOptionPane.showInputDialog("Digite seu nome:")

        val opcoes = arrayOf("Iniciar Pomodoro (25 min)", "Sair")

        var opcaoEscolhida = 0

        while (opcaoEscolhida != 1) {
            opcaoEscolhida = JOptionPane.showOptionDialog(
                null,
                "Olá $nome! O que deseja fazer?",
                "Sistema Pomodoro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            )

            if (opcaoEscolhida == 1 || opcaoEscolhida == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Saindo... Até logo, $nome!")
                break
            }

            if (opcaoEscolhida == 0) {
                var tempoTotal = 25 * 60 // 25 minutos convertido em segundos

                while (tempoTotal >= 0) {
                    val minutos = tempoTotal / 60
                    val segundos = tempoTotal % 60

                    println("Tempo restante: $minutos min e $segundos s")

                    Thread.sleep(1000) // o theread.sleep(1000) faz uma pausa de 1 segundo entre cada repetição
                    tempoTotal -= 1
                }

                JOptionPane.showMessageDialog(
                    null,
                    "Pomodoro finalizado!\nHora de uma pausa das telas.\nEu sei se você está procrastinando, ouviu $nome!"
                )
            }
        }
    }
}