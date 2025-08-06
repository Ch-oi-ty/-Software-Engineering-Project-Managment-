package com.example.fitnessapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {

        return """
<!DOCTYPE html>
<html>
<head>
    <title>Fitness Questions</title>
    <style>
        /* Soft pastel background */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f9fafc;
            margin: 0; padding: 40px 20px;
            color: #4a4a4a;
            min-height: 100vh;
        }

        h1 {
            text-align: center;
            color: #556270;
            font-weight: 700;
            font-size: 2.8rem;
            margin-bottom: 40px;
            letter-spacing: 1.1px;
        }

        /* Wrapper to center content */
        #content-wrapper {
            max-width: 700px;
            margin: 0 auto;
            padding: 0 15px;
            box-sizing: border-box;
        }

        /* Questions container */
        #questions > div {
            background: #ffffff;
            border-radius: 12px;
            padding: 22px 28px;
            margin-bottom: 24px;
            box-shadow: 0 6px 14px rgba(139, 195, 235, 0.25);
            transition: box-shadow 0.3s ease, transform 0.3s ease;
        }
        #questions > div:hover {
            box-shadow: 0 10px 24px rgba(139, 195, 235, 0.4);
            transform: translateY(-4px);
        }

        h3 {
            margin-top: 0;
            color: #000000; /* Deep black */
            font-weight: 600;
            font-size: 1.3rem;
        }

        label {
            display: block;
            margin: 12px 0;
            cursor: pointer;
            font-size: 1.1rem;
            color: #556270;
            user-select: none;
            transition: color 0.2s ease;
        }
        label:hover {
            color: #4a90e2;
        }

        input[type="radio"] {
            margin-right: 12px;
            accent-color: #81d4fa; /* soft sky blue */
            cursor: pointer;
            transform: scale(1.15);
            transition: accent-color 0.3s ease;
        }
        input[type="radio"]:hover {
            accent-color: #4a90e2;
        }

        /* Submit button */
        button {
            background: linear-gradient(135deg, #81d4fa 0%, #4a90e2 100%);
            color: white;
            border: none;
            padding: 16px 48px;
            font-size: 1.2rem;
            border-radius: 36px;
            cursor: pointer;
            font-weight: 700;
            box-shadow: 0 8px 18px rgba(74, 144, 226, 0.5);
            transition: box-shadow 0.3s ease, background 0.3s ease;
            display: block;
            margin: 30px auto 0;
            user-select: none;
        }
        button:hover {
            background: linear-gradient(135deg, #4a90e2 0%, #357ABD 100%);
            box-shadow: 0 12px 26px rgba(53, 122, 189, 0.7);
        }

        /* Suggestions box */
        #suggestions {
            background: #ffffff;
            border-radius: 16px;
            padding: 30px 40px;
            box-shadow: 0 10px 30px rgba(130, 177, 255, 0.2);
            color: #374957;
            margin-top: 50px;
        }

        #suggestions h2 {
            margin-top: 0;
            font-weight: 700;
            font-size: 1.9rem;
            border-bottom: 3px solid #81d4fa;
            padding-bottom: 10px;
            letter-spacing: 0.8px;
        }

        #suggestions ul {
            padding-left: 28px;
            margin-top: 24px;
        }

        #suggestions li {
            margin-bottom: 16px;
            font-size: 1.15rem;
            line-height: 1.5;
        }

        /* Scrollbar for questions */
        #questions {
            max-height: 68vh;
            overflow-y: auto;
            padding-right: 12px;
        }
        #questions::-webkit-scrollbar {
            width: 8px;
        }
        #questions::-webkit-scrollbar-thumb {
            background: #81d4fa;
            border-radius: 10px;
        }
        #questions::-webkit-scrollbar-track {
            background: #e8f1fc;
        }

        /* Responsive */
        @media (max-width: 720px) {
            body {
                padding: 30px 15px;
            }
            #content-wrapper {
                padding: 0 10px;
            }
            #suggestions {
                padding: 25px 30px;
                margin-top: 30px;
            }
        }
    </style>

    <script>
        async function loadQuestions() {
            const response = await fetch('/api/questions');
            const questions = await response.json();
            const container = document.getElementById('questions');
            container.innerHTML = ''; // clear before loading

            questions.forEach(q => {
                const div = document.createElement('div');
                div.innerHTML = `<h3>Question ${q.id}: ${q.questionText}</h3>`;
                q.options.forEach(opt => {
                    div.innerHTML += `<label><input type="radio" name="q${q.id}" value="${opt.id}"/> ${opt.optionText}</label>`;
                });
                container.appendChild(div);
            });
        }

        async function submitAnswers() {
            const allRadios = document.querySelectorAll('input[type="radio"]:checked');
            if(allRadios.length < document.getElementById('questions').children.length) {
                alert('Please answer all questions before submitting.');
                return;
            }

            const answers = Array.from(allRadios).map(r => ({
                questionId: parseInt(r.name.substring(1)),
                selectedOptionId: parseInt(r.value)
            }));

            const response = await fetch('/api/submit', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({ answers })
            });

            if(response.ok) {
                const data = await response.json();
                const result = document.getElementById('suggestions');
                result.innerHTML = "<h2>Suggestions:</h2><ul>" + 
                    data.suggestions.map(s => `<li>${s}</li>`).join('') + 
                    "</ul>";
            } else {
                alert('Failed to submit answers. Please try again.');
            }
        }

        window.onload = loadQuestions;
    </script>
</head>
<body>
    <h1>Fitness Assessment</h1>
    <div id="content-wrapper">
        <div id="questions"></div>
        <button onclick="submitAnswers()">Submit</button>
        <div id="suggestions"></div>
    </div>
</body>
</html>
""";

    }
}
