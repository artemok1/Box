package TH17;

/*
 * вам нужно сделать загрузку XML и JSON (¬аши тоговые задание) и обработать их. «агрузка будет в потоке загрузки данных,
 *  а парсинг в потоке обработки данных, как было сказало выше. ” вас должны получитьс€ следующа€ последовательность: 
 *  - «агружаем XML - поток 1 
 *  - ќбрабатываем XML - поток 2 
 *  - «агружаем JSON - поток 1 
 *  - ќбрабатываем JSON - поток 2 
 *  ќба потока работают на прот€жении всех дейтсвий (запущены). 
 *  XML и JSON можно хранить в файле дл€ передачи между потоками.
 */

public class Task1 {

	public static void main(String[] args) {
		Parser parser = new Parser();
		
		Reader reader = new Reader();
		
		parser.setReader(reader);
		
		reader.setParser(parser);
		
		System.out.println("start");
		reader.start();
		parser.start();
	}
}
