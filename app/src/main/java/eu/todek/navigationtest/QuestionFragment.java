package eu.todek.navigationtest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import eu.todek.navigationtest.databinding.FragmentQuestionBinding;

public class QuestionFragment extends Fragment {


    private FragmentQuestionBinding binding;
    private List<Question> questions;
    private int correctAnswers;
    private int currentQuestionIndex;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentQuestionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);
        questions = new ArrayList<>();

        questions.add(new Question("Who was the first Roman emperor ?", Arrays.asList("Augustus", "Caligula", "Nero", "Majorian"), 0));
        questions.add(new Question("The United States bought Alaska from which country ?", Arrays.asList("Canada", "The United Kingdom", "Russia", "France"), 2));
        questions.add(new Question("Who was the fourth president of the United States ?", Arrays.asList("Abraham Lincoln", "Benjamin Franklin", "Theodore Roosevelt", "James Madison"), 3));
        questions.add(new Question("Which was the largest contiguous Empire in history ?", Arrays.asList("British Empire", "Roman Empire", "Mongolian Empire", "Russian Empire"), 0));
        questions.add(new Question("Who Invented the Automobile?", Arrays.asList("Ransom Olds", "Karl Benz", "Henry Ford", "Nicolas-Joseph Cugnot"), 1));
        questions.add(new Question("Who Was the First to Settle in What’s Now the United States?", Arrays.asList("England", "France", "Germany", "Spain"), 3));
        questions.add(new Question("Which Pharaoh Led the Construction of the Pyramids of Giza?", Arrays.asList("Pharaoh Khufu", "Pharaoh Khafre", "Pharaoh Menkaure", "Cleopatra"), 0));
        questions.add(new Question("Which is the capital of the Mongolian Empire ?", Arrays.asList("Karakorum", "Tenduk", "Tataryn Kherem", "Tosokh"), 0));
        questions.add(new Question("Which is the capital of Switzerland?", Arrays.asList("Zurich", "Berlin", "Bern", "Warsaw"), 2));
        questions.add(new Question("Which is the capital of Greece", Arrays.asList("Thessaloniki", "Heraklion", "Larissa", "Athens"), 3));
        questions.add(new Question("The Chinese ruler who built the Great Wall of China?", Arrays.asList("Jin Yuzhang", "Yongzheng Emperor", "Qin Shi Huang", "Shunzhi Emperor"), 2));


        correctAnswers = 0;
        currentQuestionIndex = 0;

        Collections.shuffle(questions);

        List<Question> quizQuestions = questions.subList(0,5);
        Question currentQuestion = quizQuestions.get(currentQuestionIndex);
        updateQuestionOnUI(currentQuestion);

        binding.okButton.setOnClickListener(v -> {

            if (checkUserAnswer(quizQuestions.get(currentQuestionIndex))) {
                correctAnswers++;

            }
            currentQuestionIndex++;

            if (currentQuestionIndex > quizQuestions.size() - 1) {

                //Toast.makeText(getContext(), Integer.toString(correctAnswers), Toast.LENGTH_SHORT).show();

                NavController controller = Navigation.findNavController(getView());

                if (correctAnswers > 1) {
                 /*
                    QuestionFragmentDirections.ActionQuestionFragmentToCorrectAnswerFragment action =
                            QuestionFragmentDirections.actionQuestionFragmentToCorrectAnswerFragment();

                    action.setNCorrectAnswers(correctAnswers);
                  */

                    QuestionFragmentDirections.ActionQuestionFragmentToCorrectAnswerFragment action =
                            QuestionFragmentDirections.actionQuestionFragmentToCorrectAnswerFragment();

                    action.setNCorrectAnswers(correctAnswers);

                    controller.navigate(action);

                } else {
                    controller.navigate(QuestionFragmentDirections.actionQuestionFragmentToWrongAnswerFragment());
                }
            } else {
                updateQuestionOnUI(quizQuestions.get(currentQuestionIndex));
                binding.radioGroup.clearCheck();
            }
        });
    }

    private void updateQuestionOnUI(Question question) {
        binding.questionText.setText(question.getQuestionText());
        binding.radioButton0.setText(question.getAnswers().get(0));
        binding.radioButton1.setText(question.getAnswers().get(1));
        binding.radioButton2.setText(question.getAnswers().get(2));
        binding.radioButton3.setText(question.getAnswers().get(3));
    }

    private boolean checkUserAnswer(Question question) {
        int id = binding.radioGroup.getCheckedRadioButtonId();

        switch (question.getCorrectAnswerIndex()) {
            case 0:
                return id == R.id.radioButton0;
            case 1:
                return id == R.id.radioButton1;
            case 2:
                return id == R.id.radioButton2;
            case 3:
                return id == R.id.radioButton3;
            default:
                return false;
        }
    }

}