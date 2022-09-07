package com.example.pedrapapeltesoura


import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.*
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity(), Parcelable {

    constructor(parcel: Parcel) : this()

    @SuppressLint("ClickableViewAccessibility", "ResourceType", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var foiClicado = 0

        pedra.setOnClickListener {
            situacao.text = ""
            imageViewEscolhaUser.setBackgroundResource(R.mipmap.ic_pedra_foreground)
            imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_ask_foreground)
            foiClicado = 1
        }

        papel.setOnClickListener {
            situacao.text = ""
            imageViewEscolhaUser.setBackgroundResource(R.mipmap.ic_papel_foreground)
            imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_ask_foreground)
            foiClicado = 2
        }

        tesoura.setOnClickListener {
            situacao.text = ""
            imageViewEscolhaUser.setBackgroundResource(R.mipmap.ic_tesoura_foreground)
            imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_ask_foreground)
            foiClicado = 3
        }

        play.setOnClickListener {
            situacao.setText("")

            if (foiClicado == 0) {
                Toast.makeText(getApplicationContext(), "Escolha algo", Toast.LENGTH_SHORT).show()
            } else {
                pedra.isClickable = false
                papel.isClickable = false
                tesoura.isClickable = false
                play.isClickable = false

                var i = 0
                while (i < 2001) {
                    i++
                    if (i < 400) {
                        i++
                        Handler(Looper.getMainLooper()).postDelayed(
                            {
                                var list = listOf(1, 2, 3)
                                var number = list.random()

                                when (number) {
                                    1 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_pedra_foreground)
                                    2 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_papel_foreground)
                                    3 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_tesoura_foreground)
                                }
                            },
                            i.toLong() // value in milliseconds
                        )
                    } else if (i >= 400 && i < 800) {
                        i += 25
                        Handler(Looper.getMainLooper()).postDelayed(
                            {
                                var list = listOf(1, 2, 3)
                                var number = list.random()

                                when (number) {
                                    1 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_pedra_foreground)
                                    2 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_papel_foreground)
                                    3 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_tesoura_foreground)
                                }
                            },
                            i.toLong() // value in milliseconds
                        )
                    } else if (i > 800 && i < 1400) {
                        i += 50
                        Handler(Looper.getMainLooper()).postDelayed(
                            {
                                var list = listOf(1, 2, 3)
                                var number = list.random()

                                when (number) {
                                    1 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_pedra_foreground)
                                    2 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_papel_foreground)
                                    3 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_tesoura_foreground)
                                }
                            },
                            i.toLong() // value in milliseconds
                        )
                    } else if (i > 1400 && i < 1800) {
                        i += 100
                        Handler(Looper.getMainLooper()).postDelayed(
                            {
                                var list = listOf(1, 2, 3)
                                var number = list.random()

                                when (number) {
                                    1 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_pedra_foreground)
                                    2 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_papel_foreground)
                                    3 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_tesoura_foreground)
                                }
                            },
                            i.toLong() // value in milliseconds
                        )
                    } else if (i > 1800 && i < 2001) {
                        i += 200
                        Handler(Looper.getMainLooper()).postDelayed(
                            {
                                var list = listOf(1, 2, 3)
                                var number = list.random()

                                when (number) {
                                    1 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_pedra_foreground)
                                    2 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_papel_foreground)
                                    3 -> imageViewEscolhaBot.setBackgroundResource(R.mipmap.ic_tesoura_foreground)
                                }

                                comparar(foiClicado, number)
                            },
                            i.toLong() // value in milliseconds

                        )
                    }
                }
            }
        }

        closeStatistics.setOnClickListener {
            estatisticas.visibility = View.INVISIBLE
            a.visibility = View.VISIBLE
            a.isClickable = true
            situacao.visibility = View.VISIBLE
            situacao.isClickable = true
            b.visibility = View.VISIBLE
            b.isClickable = true
            c.visibility = View.VISIBLE
            c.isClickable = true
            d.visibility = View.VISIBLE
            d.isClickable = true
            play.visibility = View.VISIBLE
            play.isClickable = true
        }

        closeHowToPlay.setOnClickListener {
            menu.visibility = View.INVISIBLE
            a.visibility = View.VISIBLE
            a.isClickable = true
            situacao.visibility = View.VISIBLE
            situacao.isClickable = true
            b.visibility = View.VISIBLE
            b.isClickable = true
            c.visibility = View.VISIBLE
            c.isClickable = true
            d.visibility = View.VISIBLE
            d.isClickable = true
            play.visibility = View.VISIBLE
            play.isClickable = true
        }

    }


    //Mostrar o botão de configuração
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    @Suppress("UNSAFE_CALL_ON_PARTIALLY_DEFINED_RESOURCE")
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.howToPlay -> {
            if (estatisticas.visibility == View.VISIBLE) {
                estatisticas.visibility = View.INVISIBLE
            }

            menu.visibility = View.VISIBLE
            a.visibility = View.INVISIBLE
            a.isClickable = false
            situacao.visibility = View.INVISIBLE
            situacao.isClickable = false
            b.visibility = View.INVISIBLE
            b.isClickable = false
            c.visibility = View.INVISIBLE
            c.isClickable = false
            d.visibility = View.INVISIBLE
            d.isClickable = false
            play.visibility = View.INVISIBLE
            play.isClickable = false

            true
        }

        R.id.estatisticas -> {
            if (menu.visibility == View.VISIBLE) {
                menu.visibility = View.INVISIBLE
            }
            estatisticas.visibility = View.VISIBLE
            a.visibility = View.INVISIBLE
            a.isClickable = false
            situacao.visibility = View.INVISIBLE
            situacao.isClickable = false
            b.visibility = View.INVISIBLE
            b.isClickable = false
            c.visibility = View.INVISIBLE
            c.isClickable = false
            d.visibility = View.INVISIBLE
            d.isClickable = false
            play.visibility = View.INVISIBLE
            play.isClickable = false
            true
        }

        R.id.aboutDeveloper -> {
            if (menu.visibility == View.VISIBLE) {
                menu.visibility = View.INVISIBLE
            }
            if (estatisticas.visibility == View.VISIBLE) {
                estatisticas.visibility = View.INVISIBLE
            }
            a.visibility = View.VISIBLE
            a.isClickable = true
            situacao.visibility = View.VISIBLE
            situacao.isClickable = true
            b.visibility = View.VISIBLE
            b.isClickable = true
            c.visibility = View.VISIBLE
            c.isClickable = true
            d.visibility = View.VISIBLE
            d.isClickable = true
            play.visibility = View.VISIBLE
            play.isClickable = true
            val uri: Uri = Uri.parse("https://github.com/Pedro-1302")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    @SuppressLint("SetTextI18n")
    fun comparar(escolhaUser: Int, escolhaBot: Int) {
        var userChoice = escolhaUser
        var botChoice = escolhaBot

        when (botChoice) {
            1 -> when (userChoice) {
                1 -> situacao.text = "Empate"
                2 -> situacao.text = "Vitoria"
                3 -> situacao.text = "Derrota"
            }
            2 -> when (userChoice) {
                1 -> situacao.text = "Derrota"
                3 -> situacao.text = "Vitoria"
                2 -> situacao.text = "Empate"
            }
            3 -> when (userChoice) {
                1 -> situacao.text = "Vitoria"
                3 -> situacao.text = "Empate"
                2 -> situacao.text = "Derrota"
            }
        }

        Handler(Looper.getMainLooper()).postDelayed(
            {
                ativarEscolha()
            },
            1000// value in milliseconds
        )

        var i = 0
        if (situacao.text == "Vitoria") {
            i++
            vitorias += i
            winsCont.text = vitorias.toString()
        }
        if (situacao.text == "Derrota") {
            i++
            derrotas += i
            losesCont.text = derrotas.toString()
        }
        if (situacao.text == "Empate") {
            i++
            empates += i
            drawsCont.text = empates.toString()
        }
    }

    private var vitorias = 0
    private var derrotas = 0
    private var empates = 0

    fun ativarEscolha() {
        pedra.isClickable = true
        papel.isClickable = true
        tesoura.isClickable = true
        play.isClickable = true
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }


}



