package com.projeto.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;


public class FlippyBird extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture[] passaro;
	private Texture fundo;
	private Texture canobaixo;
	private Texture canotopo;
	private Random randomico;

	//Atributos de configuração

	private  int larguradisp;
	private  int alturadips;

	private float variacao = 0;
	private  float velocidadequeda = 0;
	private float posicaoinicialvertical;
	private float posicaomovimentocanohorizontal;
	private  float movimentocanohorizontal = larguradisp;
	private float espacoentrecanos;
	private  float deltatime;
	private  float alturaentrecandosrandomica;

	@Override
	public void create () {

		batch = new SpriteBatch();
		randomico = new Random();
		passaro = new Texture[3];
		//passaro [0]= new Texture("Luz central.png");
		//passaro [1]= new Texture("Luz central2.png");
		passaro [0]= new Texture("passaro1.png");
		passaro [1]= new Texture("passaro2.png");
		passaro [2]= new Texture("passaro3.png");
		fundo = new Texture("fundo.png");
		canobaixo = new Texture("Luz central2.png");
		canotopo = new Texture("Luz central2.png");
		//canobaixo = new Texture("cano_baixo.png");
		//canotopo = new Texture("cano_topo.png");

		larguradisp = Gdx.graphics.getWidth();
		alturadips = Gdx.graphics.getHeight();
		posicaoinicialvertical = alturadips/2;
		posicaomovimentocanohorizontal = larguradisp - 100;
		espacoentrecanos = 300;

	}

	@Override
	public void render () {

        deltatime = Gdx.graphics.getDeltaTime();
		variacao += deltatime*3;
		posicaomovimentocanohorizontal -= deltatime*300;
		velocidadequeda++;
	//	Gdx.app.log("Variação", "Variação" + Gdx.graphics.getDeltaTime() );
		if (variacao >2) variacao = 0;


		if(Gdx.input.justTouched()){
			velocidadequeda = -15;

		}

		if (posicaoinicialvertical > 0 || velocidadequeda < 0 )
		posicaoinicialvertical = posicaoinicialvertical - velocidadequeda;


		//Verifica se o cano saiu da tela
		if (posicaomovimentocanohorizontal < -canotopo.getWidth()){

			posicaomovimentocanohorizontal = larguradisp ;
			alturaentrecandosrandomica = randomico.nextInt(400) - 200;


		}

		batch.begin();

		batch.draw(fundo, 0 , 0, larguradisp, alturadips);
		batch.draw(canotopo,posicaomovimentocanohorizontal,alturadips/2 + espacoentrecanos/2 + alturaentrecandosrandomica);
		batch.draw(canobaixo, posicaomovimentocanohorizontal, alturadips/2 - canobaixo.getHeight() - espacoentrecanos/2 + alturaentrecandosrandomica);
		//batch.draw(passaro[(int)variacao], 120, posicaoinicialvertical);
		batch.draw(passaro[(int)variacao],30,alturadips/2);

		batch.end();


	}


}
