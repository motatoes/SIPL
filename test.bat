if not exist test_out md test_out

for /f %%f in  ('dir /b test') do java Main test\%%f > test_out\%%f 