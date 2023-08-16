public class Oyun {

        public static void main(String[] args) {
            int[][] tahta = new int[9][9];
            tahtaOlustur(tahta);

            System.out.println("Baslangicta Sudoku Tahtasi:");
            tahtaGoster(tahta);

            if (cozSudoku(tahta)) {
                System.out.println("Cozulmus Sudoku Tahtasi:");
                tahtaGoster(tahta);
            } else {
                System.out.println("Sudoku cozulemedi.");
            }
        }

        // Sudoku tahtasini olusturma
        public static void tahtaOlustur(int[][] tahta) {
            // Tahtanin baslangic durumu burada olusturulabilir.
            // Bos hucreler 0 olarak temsil edilir.
        }

        // Sudoku tahtasini ekrana yazdirma
        public static void tahtaGoster(int[][] tahta) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(tahta[i][j] + " ");
                }
                System.out.println();
            }
        }

        // Sudoku tahtasini cozme
        public static boolean cozSudoku(int[][] tahta) {
            int[] koordinat = bosHucreBul(tahta);
            if (koordinat == null) {
                return true;  // Tum hucreler dolu ise cozulmus demektir.
            }

            int satir = koordinat[0];
            int sutun = koordinat[1];

            for (int num = 1; num <= 9; num++) {
                if (gecerliHamle(tahta, satir, sutun, num)) {
                    tahta[satir][sutun] = num;

                    if (cozSudoku(tahta)) {
                        return true;
                    }

                    tahta[satir][sutun] = 0;  // Geri adim at
                }
            }

            return false;

        }

        // Belirli bir hucreye rakam yerlestirip yerlestiremeyecegimizi kontrol etme
        public static boolean gecerliHamle(int[][] tahta, int satir, int sutun, int num) {
            // Ayni satir ve sutunda rakam kontrolu
            for (int i = 0; i < 9; i++) {
                if (tahta[satir][i] == num || tahta[i][sutun] == num) {
                    return false;
                }
            }

            // Aynı 3x3 kutuda rakam kontrolu
            int baslangicSatir = satir - satir % 3;
            int baslangicSutun = sutun - sutun % 3;
            for (int i = baslangicSatir; i < baslangicSatir + 3; i++) {
                for (int j = baslangicSutun; j < baslangicSutun + 3; j++) {
                    if (tahta[i][j] == num) {
                        return false;
                    }
                }
            }

            return true;
        }

        // Bos bir hucre bulma
        public static int[] bosHucreBul(int[][] tahta) {
            int[] koordinat = new int[2];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (tahta[i][j] == 0) {
                        koordinat[0] = i;
                        koordinat[1] = j;
                        return koordinat;
                    }
                }
            }
            return null;
        }
    }


