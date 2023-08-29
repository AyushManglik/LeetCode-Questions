int maxScore = 0;
int bestIndex = 0;
int currentScore = 0;
for (int i = 0; i < customers.length(); ++i) {
  char customerShowedUp = customers.charAt(i);
  if (customerShowedUp == 'Y') {
    ++currentScore;
  } else {
    --currentScore;
  }
  if (maxScore < currentScore) {
    maxScore = currentScore;
    bestIndex = i + 1;
  }
}
return bestIndex;
