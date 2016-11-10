package webRequestListener;

public class WebRequestListener {
		//Счётчик запущеных потоков
		public static int mTreadCounter = 0;
		
		static ListenerThread mListenThread;
		static ListenerThread mLTArray[];	//Массив объектов потоков
		
		
			
		public static void main(String[] arg) {
			
			ListenerThread mLTArray[] = new ListenerThread[10];
			
			// Цикл порождения потоков
			for(int i = 0; i < 3; i++)
			{	
				mLTArray[i] = new ListenerThread();	//Создание i-потока 
				System.out.println("Запускаю поток № " + i + "   ");
				mLTArray[i].start();	//Запуск i-го потока
				
				
//				try{
//					if(i>0)//постановка i-го потока в очередь за i-1-ым
//					{
//						mLTArray[i-1].join();
//						
//					} 
//				}catch(InterruptedException e){
//					return;	//Завершение потока после прерывания
//				}
				
				//if (i>0) mLTArray[i-1].interrupt();
			
			}
			
			
			for(int j = 0; j < 2; j++)
			{
				//lThr.interrupt();	//Прерывание j-го потока
				//mLTArray[0].interrupt(); //Прерывание j-го потока
			}

				
		}
}


class ListenerThread extends Thread
{

	@Override
	public void run()
	{
		
		System.out.println("Поток " + this.toString() + " запущен   ");
		
		do
		{
			if(!Thread.interrupted())	//Проверка прерывания
			{
				//Вывод сообщения запущенного потока
				System.out.println(this.toString());
								
			}
			else
				return;		//Завершение потока	

			try{
				Thread.sleep(3000);		//Приостановка потока на 1 сек.
			}catch(InterruptedException e){
				return;	//Завершение потока после прерывания
			}
		}
		while(true); 
	}
}

