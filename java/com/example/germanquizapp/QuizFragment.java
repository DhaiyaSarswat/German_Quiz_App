package com.example.germanquizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.germanquizapp.databinding.FragmentQuizBinding;
import com.example.germanquizapp.modelClass.QuizModel;
import com.example.germanquizapp.modelClass.SubModel;

import java.util.ArrayList;
import java.util.Objects;

public class QuizFragment extends Fragment {
    private FragmentQuizBinding binding;
    private ArrayList<QuizModel> list = new ArrayList<>();
    private int position = 0;
    private int right = 0;
    private static String answer = null;
    String category,title;
    public QuizFragment(String category,String title) {
        this.category=category;
        this.title=title;
        // Required empty public constructor
    }
    private int allQuestion;
    private String listSize;
    private String positionNo;
    private QuizModel quizModel;

    public QuizFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuizBinding.inflate(inflater, container, false);
        loadQuestion();
        EnableOption();
        ClearOption();

        binding.nextBtn.setOnClickListener(v -> {
            position++;
            if (position < allQuestion) {
                loadQuestion();
                EnableOption();
                ClearOption();
            } else {
                navigateToResultFragment();
            }
        });

        return binding.getRoot();
    }

    private void navigateToResultFragment() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.wrapper, new ResultFragment(right, allQuestion,category,title))
                .commit();
        list.clear();
        position = 0;
    }

    private void ClearOption() {
        binding.option1Cont.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option1Cont.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
        binding.option2Cont.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option2Cont.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
        binding.option3Cont.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option3Cont.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
        binding.option4Cont.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option4Cont.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
        binding.nextBtn.setBackgroundResource(R.drawable.disable_btn);
    }

    private void EnableOption() {
        binding.option1Cont.setEnabled(true);
        binding.option2Cont.setEnabled(true);
        binding.option3Cont.setEnabled(true);
        binding.option4Cont.setEnabled(true);
        binding.nextBtn.setEnabled(false);
    }

    private void loadQuestion() {
        switch (title) {
        case "Household Items":
        list.clear();
            list.add(new QuizModel("What is 'Bett' in English?", "Bed", "Table", "Chair", "Sofa", "Bed"));
            list.add(new QuizModel("What is 'Lampe' in English?", "Lamp", "Fan", "Clock", "Shelf", "Lamp"));
            list.add(new QuizModel("What is 'Schrank' in English?", "Wardrobe", "Desk", "Curtain", "Rug", "Wardrobe"));
            list.add(new QuizModel("What is 'Teppich' in English?", "Carpet", "Cushion", "Mirror", "Door", "Carpet"));
            list.add(new QuizModel("What is 'Stuhl' in English?", "Chair", "Couch", "Table", "Bed", "Chair"));

            setUp();
        break;
        case "Kitchen Utensils":
        list.clear();
            list.add(new QuizModel("What is 'Messer' in English?", "Knife", "Fork", "Spoon", "Plate", "Knife"));
            list.add(new QuizModel("What is 'Gabel' in English?", "Fork", "Knife", "Spoon", "Bowl", "Fork"));
            list.add(new QuizModel("What is 'Teller' in English?", "Plate", "Cup", "Glass", "Pan", "Plate"));
            list.add(new QuizModel("What is 'Pfanne' in English?", "Pan", "Pot", "Kettle", "Tray", "Pan"));
            list.add(new QuizModel("What is 'Löffel' in English?", "Spoon", "Fork", "Knife", "Plate", "Spoon"));

            setUp();
        break;
        case "Personal Items":
        list.clear();
            list.add(new QuizModel("What is 'Zahnbürste' in English?", "Toothbrush", "Comb", "Brush", "Toothpaste", "Toothbrush"));
            list.add(new QuizModel("What is 'Kamm' in English?", "Comb", "Brush", "Razor", "Mirror", "Comb"));
            list.add(new QuizModel("What is 'Spiegel' in English?", "Mirror", "Glass", "Window", "Picture", "Mirror"));
            list.add(new QuizModel("What is 'Seife' in English?", "Soap", "Shampoo", "Lotion", "Cream", "Soap"));
            list.add(new QuizModel("What is 'Handtuch' in English?", "Towel", "Rug", "Blanket", "Cloth", "Towel"));

            setUp();
        break;
        case "Office Supplies":
        list.clear();
            list.add(new QuizModel("What is 'Bürostuhl' in English?", "Office Chair", "Desk", "File", "Cabinet", "Office Chair"));
            list.add(new QuizModel("What is 'Tacker' in English?", "Stapler", "Tape", "Clip", "Pen", "Stapler"));
            list.add(new QuizModel("What is 'Schere' in English?", "Scissors", "Stapler", "Pen", "Paper", "Scissors"));
            list.add(new QuizModel("What is 'Heft' in English?", "Notebook", "Folder", "Paper", "Book", "Notebook"));
            list.add(new QuizModel("What is 'Kugelschreiber' in English?", "Pen", "Pencil", "Marker", "Eraser", "Pen"));

            setUp();
        break;
        case "Electronic Devices":
            list.clear();
            list.add(new QuizModel("What is 'Laptop' in English?", "Laptop", "Tablet", "Phone", "Monitor", "Laptop"));
            list.add(new QuizModel("What is 'Handy' in English?", "Mobile Phone", "Tablet", "Computer", "Camera", "Mobile Phone"));
            list.add(new QuizModel("What is 'Kamera' in English?", "Camera", "Speaker", "Radio", "Monitor", "Camera"));
            list.add(new QuizModel("What is 'Fernseher' in English?", "Television", "Radio", "Computer", "Projector", "Television"));
            list.add(new QuizModel("What  is 'Mikrofon' in English?", "Microphone", "Speaker", "Headphone", "Amplifier", "Microphone"));
            setUp();
            break;
            // Category 2
            case "Parents":
                list.clear();
                list.add(new QuizModel("Who is 'Mutter' in English?", "Mother", "Father", "Sister", "Brother", "Mother"));
                list.add(new QuizModel("Who is 'Vater' in English?", "Father", "Mother", "Sister", "Brother", "Father"));
                list.add(new QuizModel("Who is 'Eltern' in English?", "Parents", "Children", "Relatives", "Grandparents", "Parents"));
                list.add(new QuizModel("Who is 'Tochter' in English?", "Daughter", "Son", "Niece", "Nephew", "Daughter"));
                list.add(new QuizModel("Who is 'Sohn' in English?", "Son", "Daughter", "Niece", "Nephew", "Son"));
                setUp();
                break;

            case "Siblings":
                list.clear();
                list.add(new QuizModel("Who is 'Bruder' in English?", "Brother", "Sister", "Father", "Mother", "Brother"));
                list.add(new QuizModel("Who is 'Schwester' in English?", "Sister", "Brother", "Father", "Mother", "Sister"));
                list.add(new QuizModel("Who is 'Geschwister' in English?", "Siblings", "Parents", "Relatives", "Children", "Siblings"));
                list.add(new QuizModel("Who is 'Halbbruder' in English?", "Half-brother", "Half-sister", "Stepbrother", "Stepsister", "Half-brother"));
                list.add(new QuizModel("Who is 'Stiefschwester' in English?", "Stepsister", "Stepbrother", "Half-sister", "Half-brother", "Stepsister"));
                setUp();
                break;

            case "Extended Family":
                list.clear();
                list.add(new QuizModel("Who is 'Großvater' in English?", "Grandfather", "Grandmother", "Uncle", "Aunt", "Grandfather"));
                list.add(new QuizModel("Who is 'Großmutter' in English?", "Grandmother", "Grandfather", "Uncle", "Aunt", "Grandmother"));
                list.add(new QuizModel("Who is 'Onkel' in English?", "Uncle", "Aunt", "Cousin", "Nephew", "Uncle"));
                list.add(new QuizModel("Who is 'Tante' in English?", "Aunt", "Uncle", "Cousin", "Niece", "Aunt"));
                list.add(new QuizModel("Who is 'Cousin' in English?", "Cousin", "Sibling", "Grandparent", "Parent", "Cousin"));
                setUp();
                break;
            case "Relatives":
                list.clear();
                list.add(new QuizModel("Who is 'Verwandte' in English?", "Relatives", "Friends", "Neighbors", "Colleagues", "Relatives"));
                list.add(new QuizModel("Who is 'Schwager' in English?", "Brother-in-law", "Sister-in-law", "Father-in-law", "Mother-in-law", "Brother-in-law"));
                list.add(new QuizModel("Who is 'Schwägerin' in English?", "Sister-in-law", "Brother-in-law", "Father-in-law", "Mother-in-law", "Sister-in-law"));
                list.add(new QuizModel("Who is 'Neffe' in English?", "Nephew", "Niece", "Cousin", "Sibling", "Nephew"));
                list.add(new QuizModel("Who is 'Nichte' in English?", "Niece", "Nephew", "Cousin", "Sibling", "Niece"));
                setUp();
                break;
            case "Children":
                list.clear();
                list.add(new QuizModel("Who is 'Kind' in English?", "Child", "Parent", "Grandparent", "Relative", "Child"));
                list.add(new QuizModel("Who is 'Sohn' in English?", "Son", "Daughter", "Nephew", "Niece", "Son"));
                list.add(new QuizModel("Who is 'Tochter' in English?", "Daughter", "Son", "Nephew", "Niece", "Daughter"));
                list.add(new QuizModel("Who is 'Enkel' in English?", "Grandchild", "Grandparent", "Sibling", "Cousin", "Grandchild"));
                list.add(new QuizModel("Who is 'Enkelin' in English?", "Granddaughter", "Grandson", "Niece", "Nephew", "Granddaughter"));
                setUp();
                break;
            // Category 3
            case "Mammals":
                list.clear();
                list.add(new QuizModel("What is 'Hund' in English?", "Dog", "Cat", "Horse", "Cow", "Dog"));
                list.add(new QuizModel("What is 'Katze' in English?", "Cat", "Dog", "Rabbit", "Bird", "Cat"));
                list.add(new QuizModel("What is 'Pferd' in English?", "Horse", "Cow", "Sheep", "Goat", "Horse"));
                list.add(new QuizModel("What is 'Kuh' in English?", "Cow", "Horse", "Pig", "Sheep", "Cow"));
                list.add(new QuizModel("What is 'Schwein' in English?", "Pig", "Sheep", "Goat", "Cow", "Pig"));
                setUp();
                break;

            case "Birds":
                list.clear();
                list.add(new QuizModel("What is 'Vogel' in English?", "Bird", "Fish", "Insect", "Reptile", "Bird"));
                list.add(new QuizModel("What is 'Ente' in English?", "Duck", "Chicken", "Goose", "Swan", "Duck"));
                list.add(new QuizModel("What is 'Huhn' in English?", "Chicken", "Duck", "Turkey", "Pigeon", "Chicken"));
                list.add(new QuizModel("What is 'Adler' in English?", "Eagle", "Hawk", "Falcon", "Owl", "Eagle"));
                list.add(new QuizModel("What is 'Pinguin' in English?", "Penguin", "Seagull", "Pelican", "Stork", "Penguin"));
                setUp();
                break;
            case "Aquatic Animals":
                list.clear();
                list.add(new QuizModel("What is 'Fisch' in English?", "Fish", "Shark", "Dolphin", "Whale", "Fish"));
                list.add(new QuizModel("What is 'Delphin' in English?", "Dolphin", "Shark", "Fish", "Whale", "Dolphin"));
                list.add(new QuizModel("What is 'Wal' in English?", "Whale", "Dolphin", "Shark", "Fish", "Whale"));
                list.add(new QuizModel("What is 'Haifisch' in English?", "Shark", "Dolphin", "Whale", "Fish", "Shark"));
                list.add(new QuizModel("What is 'Schildkröte' in English?", "Turtle", "Frog", "Lizard", "Snake", "Turtle"));
                setUp();
                break;

            case "Insects":
                list.clear();
                list.add(new QuizModel("What is 'Biene' in English?", "Bee", "Ant", "Fly", "Mosquito", "Bee"));
                list.add(new QuizModel("What is 'Ameise' in English?", "Ant", "Bee", "Beetle", "Butterfly", "Ant"));
                list.add(new QuizModel("What is 'Fliege' in English?", "Fly", "Bee", "Ant", "Beetle", "Fly"));
                list.add(new QuizModel("What is 'Schmetterling' in English?", "Butterfly", "Ant", "Fly", "Mosquito", "Butterfly"));
                list.add(new QuizModel("What is 'Käfer' in English?", "Beetle", "Ant", "Fly", "Butterfly", "Beetle"));
                setUp();
                break;

            case "Reptiles":
                list.clear();
                list.add(new QuizModel("What is 'Schlange' in English?", "Snake", "Lizard", "Turtle", "Crocodile", "Snake"));
                list.add(new QuizModel("What is 'Eidechse' in English?", "Lizard", "Snake", "Turtle", "Crocodile", "Lizard"));
                list.add(new QuizModel("What is 'Krokodil' in English?", "Crocodile", "Snake", "Lizard", "Turtle", "Crocodile"));
                list.add(new QuizModel("What is 'Alligator' in English?", "Alligator", "Crocodile", "Snake", "Lizard", "Alligator"));
                list.add(new QuizModel("What is 'Echse' in English?", "Lizard", "Snake", "Turtle", "Crocodile", "Lizard"));
                setUp();
                break;


            // Category 4
            case "Fruits":
                list.clear();
                list.add(new QuizModel("What is 'Apfel' in English?", "Apple", "Banana", "Orange", "Grape", "Apple"));
                list.add(new QuizModel("What is 'Banane' in English?", "Banana", "Apple", "Orange", "Grape", "Banana"));
                list.add(new QuizModel("What is 'Orange' in English?", "Orange", "Apple", "Banana", "Grape", "Orange"));
                list.add(new QuizModel("What is 'Traube' in English?", "Grape", "Apple", "Banana", "Orange", "Grape"));
                list.add(new QuizModel("What is 'Erdbeere' in English?", "Strawberry", "Apple", "Banana", "Orange", "Strawberry"));
                setUp();
                break;

            case "Vegetables":
                list.clear();
                list.add(new QuizModel("What is 'Tomate' in English?", "Tomato", "Potato", "Carrot", "Cucumber", "Tomato"));
                list.add(new QuizModel("What is 'Kartoffel' in English?", "Potato", "Tomato", "Carrot", "Cucumber", "Potato"));
                list.add(new QuizModel("What is 'Karotte' in English?", "Carrot", "Tomato", "Potato", "Cucumber", "Carrot"));
                list.add(new QuizModel("What is 'Gurke' in English?", "Cucumber", "Tomato", "Potato", "Carrot", "Cucumber"));
                list.add(new QuizModel("What is 'Paprika' in English?", "Bell Pepper", "Tomato", "Potato", "Carrot", "Bell Pepper"));
                setUp();
                break;

            case "Beverages":
                list.clear();
                list.add(new QuizModel("What is 'Wasser' in English?", "Water", "Juice", "Tea", "Coffee", "Water"));
                list.add(new QuizModel("What is 'Saft' in English?", "Juice", "Water", "Tea", "Coffee", "Juice"));
                list.add(new QuizModel("What is 'Tee' in English?", "Tea", "Water", "Juice", "Coffee", "Tea"));
                list.add(new QuizModel("What is 'Kaffee' in English?", "Coffee", "Water", "Juice", "Tea", "Coffee"));
                list.add(new QuizModel("What is 'Milch' in English?", "Milk", "Water", "Juice", "Tea", "Milk"));
                setUp();
                break;

            case "Dairy Products":
                list.clear();
                list.add(new QuizModel("What is 'Käse' in English?", "Cheese", "Butter", "Milk", "Yogurt", "Cheese"));
                list.add(new QuizModel("What is 'Butter' in English?", "Butter", "Cheese", "Milk", "Yogurt", "Butter"));
                list.add(new QuizModel("What is 'Milch' in English?", "Milk", "Cheese", "Butter", "Yogurt", "Milk"));
                list.add(new QuizModel("What is 'Joghurt' in English?", "Yogurt", "Cheese", "Butter", "Milk", "Yogurt"));
                list.add(new QuizModel("What is 'Sahne' in English?", "Cream", "Cheese", "Butter", "Milk", "Cream"));
                setUp();
                break;

            case "Snacks":
                list.clear();
                list.add(new QuizModel("What is 'Schokolade' in English?", "Chocolate", "Chips", "Cookies", "Candy", "Chocolate"));
                list.add(new QuizModel("What is 'Chips' in English?", "Chips", "Chocolate", "Cookies", "Candy", "Chips"));
                list.add(new QuizModel("What is 'Kekse' in English?", "Cookies", "Chocolate", "Chips", "Candy", "Cookies"));
                list.add(new QuizModel("What is 'Bonbon' in English?", "Candy", "Chocolate", "Chips", "Cookies", "Candy"));
                list.add(new QuizModel("What is 'Popcorn' in English?", "Popcorn", "Chocolate", "Chips", "Cookies", "Popcorn"));
                setUp();
                break;

            // Category 5
            case "Cardinal Numbers":
                list.clear();
                list.add(new QuizModel("What is 'Zahl' in English?", "Number", "Letter", "Word", "Sentence", "Number"));
                list.add(new QuizModel("What is 'Drei' in English?", "Three", "Two", "Four", "Five", "Three"));
                list.add(new QuizModel("What is 'Sechs' in English?", "Six", "Seven", "Eight", "Nine", "Six"));
                list.add(new QuizModel("What is 'Zehn' in English?", "Ten", "Eleven", "Twelve", "Thirteen", "Ten"));
                list.add(new QuizModel("What is 'Zwanzig' in English?", "Twenty", "Thirty", "Forty", "Fifty", "Twenty"));
                setUp();
                break;

            case "Ordinal Numbers":
                list.clear();
                list.add(new QuizModel("What is 'Erste' in English?", "First", "Second", "Third", "Fourth", "First"));
                list.add(new QuizModel("What is 'Zweite' in English?", "Second", "First", "Third", "Fourth", "Second"));
                list.add(new QuizModel("What is 'Dritte' in English?", "Third", "First", "Second", "Fourth", "Third"));
                list.add(new QuizModel("What is 'Vierte' in English?", "Fourth", "First", "Second", "Third", "Fourth"));
                list.add(new QuizModel("What is 'Fünfte' in English?", "Fifth", "Sixth", "Seventh", "Eighth", "Fifth"));
                setUp();
                break;

            case "Fractions and Decimals":
                list.clear();
                list.add(new QuizModel("What is 'Bruch' in English?", "Fraction", "Decimal", "Whole number", "Ratio", "Fraction"));
                list.add(new QuizModel("What is 'Drittel' in English?", "Third", "Half", "Quarter", "Fifth", "Third"));
                list.add(new QuizModel("What is 'Zehntel' in English?", "Tenth", "Fifth", "Quarter", "Half", "Tenth"));
                list.add(new QuizModel("What is '0.5' as a fraction?", "1/2", "1/4", "3/4", "1/3", "1/2"));
                list.add(new QuizModel("What is '0.75' as a fraction?", "3/4", "1/2", "1/4", "1/3", "3/4"));
                setUp();
                break;

            case "Roman Numerals":
                list.clear();
                list.add(new QuizModel("What is 'I' in Arabic numerals?", "1", "2", "3", "4", "1"));
                list.add(new QuizModel("What is 'V' in Arabic numerals?", "5", "6", "7", "8", "5"));
                list.add(new QuizModel("What is 'X' in Arabic numerals?", "10", "20", "30", "40", "10"));
                list.add(new QuizModel("What is 'L' in Arabic numerals?", "50", "60", "70", "80", "50"));
                list.add(new QuizModel("What is 'C' in Arabic numerals?", "100", "200", "300", "400", "100"));
                setUp();
                break;

            case "Prime Numbers":
                list.clear();
                list.add(new QuizModel("What is the smallest prime number?", "2", "3", "5", "1", "2"));
                list.add(new QuizModel("What is the largest single-digit prime number?", "7", "5", "3", "1", "7"));
                list.add(new QuizModel("What is the sum of the first three prime numbers?", "10", "12", "14", "16", "10"));
                list.add(new QuizModel("What is the product of the first four prime numbers?", "210", "120", "60", "24", "210"));
                list.add(new QuizModel("What is the only even prime number?", "2", "3", "5", "7", "2"));
                setUp();
                break;
        }


    }

    private void setUp(){
        allQuestion = 5;
        listSize = String.valueOf(allQuestion);
        binding.totalQ.setText("/" + listSize);

        if (position < allQuestion) {
            positionNo = String.valueOf(position + 1);
            binding.qNo.setText(positionNo);
        }

        quizModel = list.get(position);
        answer = quizModel.getCorrectAns();

        binding.questionCont.setText(quizModel.getQuestion());
        binding.option1Cont.setText(quizModel.getOp1());
        binding.option2Cont.setText(quizModel.getOp2());
        binding.option3Cont.setText(quizModel.getOp3());
        binding.option4Cont.setText(quizModel.getOp4());

        optionCheckup();

    }

    private void optionCheckup() {
        binding.option1Cont.setOnClickListener(v -> checkAnswer(binding.option1Cont));
        binding.option2Cont.setOnClickListener(v -> checkAnswer(binding.option2Cont));
        binding.option3Cont.setOnClickListener(v -> checkAnswer(binding.option3Cont));
        binding.option4Cont.setOnClickListener(v -> checkAnswer(binding.option4Cont));
    }

    private void checkAnswer(View view) {
        String selectedAnswer = ((TextView) view).getText().toString();
        if (Objects.equals(selectedAnswer, quizModel.getCorrectAns())) {
            right++;
            view.setBackgroundResource(R.drawable.right_bg);
            ((TextView) view).setTextColor(ContextCompat.getColor(requireContext(), R.color.white));
        } else {
            ShowRightAns();
            view.setBackgroundResource(R.drawable.wrong_bg);
            ((TextView) view).setTextColor(ContextCompat.getColor(requireContext(), R.color.white));
        }
        DisableOption();
        binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
    }

    private void DisableOption() {
        binding.option1Cont.setEnabled(false);
        binding.option2Cont.setEnabled(false);
        binding.option3Cont.setEnabled(false);
        binding.option4Cont.setEnabled(false);
        binding.nextBtn.setEnabled(true);
    }

    private void ShowRightAns() {
        if (Objects.equals(binding.option1Cont.getText(), quizModel.getCorrectAns())) {
            binding.option1Cont.setBackgroundResource(R.drawable.right_bg);
            binding.option1Cont.setTextColor(ContextCompat.getColor(requireContext(), R.color.white));
        } else if (Objects.equals(binding.option2Cont.getText(), quizModel.getCorrectAns())) {
            binding.option2Cont.setBackgroundResource(R.drawable.right_bg);
            binding.option2Cont.setTextColor(ContextCompat.getColor(requireContext(), R.color.white));
        } else if (Objects.equals(binding.option3Cont.getText(), quizModel.getCorrectAns())) {
            binding.option3Cont.setBackgroundResource(R.drawable.right_bg);
            binding.option3Cont.setTextColor(ContextCompat.getColor(requireContext(), R.color.white));
        } else if (Objects.equals(binding.option4Cont.getText(), quizModel.getCorrectAns())) {
            binding.option4Cont.setBackgroundResource(R.drawable.right_bg);
            binding.option4Cont.setTextColor(ContextCompat.getColor(requireContext(), R.color.white));
        }
    }
}
