if not exist test mkdir test_out

for /f %%f in  ('dir /b test') do java Main test\%%f > test_out\%%f 