package webRequestListener;

public class WebRequestListener {
		//Счётчик запущеных потоков
		public static int mTreadCounter = 0;
		
		static ListenerThread mListenThread;
		static ListenerThread mLTArray[];	//Массив объектов потоков
		
		
			
		public static void main(String[] arg) {
			
			ListenerThread mLTArray[] = new ListenerThread[10];
			
			// Цикл порождения потоков
			for(int i = 0; i < 4; i++)
			{	
				mLTArray[i] = new ListenerThread();	//Создание i-потока 
				System.out.println("Я main, запускаю поток № " + i + "   ");
				mLTArray[i].start();	//Запуск i-го потока
			}

			// прерывание потоков с паузой в 3 сек
			for(int j = 0; j < 4; j++)
			{
						
				try{
					Thread.sleep(3000);	
					System.out.println("main thread sleep ");
					mLTArray[j].interrupt(); //Прерывание j-го потока
					System.out.println("Я main, прерываю поток № " + j + "   ");
				}catch(InterruptedException e){
					System.out.println(e);
					return;	//Завершение потока после прерывания
				}
			}
		}
}


class ListenerThread extends Thread
{

	@Override
	public void run()
	{
		
		System.out.println("Я Поток " + this.toString() + ", я запустился  ");
		
		do
		{
			if(!Thread.interrupted())	//Проверка прерывания
			{
				//Вывод сообщения запущенного потока
				System.out.println("Я Поток " + this.toString() + ", я работаю  ");								
			}
			else
				return;		//Завершение потока	

			try{
				Thread.sleep(1000);		//Приостановка потока на 1 сек.
			}catch(InterruptedException e){
				return;	//Завершение потока после прерывания
			}
		}
		while(true); 
	}
}

