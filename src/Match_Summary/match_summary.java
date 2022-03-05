package Match_Summary;

public class match_summary {


//        def match_summary():
//    # Toss
//        print('\n\n---------------------------------------------------------Match Summary------------------------------------------\n')
//        match_toss = ''
//        match_result = ''
//
//        if selection == toss:
//        match_toss = str(visiting_team[0].replace(
//                '_', ' ')+' Won the toss and chose to ' + choose)
//        print(match_toss)
//        print('\n')
//    else:
//        match_toss = str(home_team[0].replace(
//                '_', ' ')+' Won the toss and chose to ' + choose)
//        print(match_toss)
//        print('\n')
//
//        print('------------------------------------------------------First Innings Top Performers---------------------------------\n\n')
//        print(team_to_bat[0].replace('_', ' '))
//        print(df_score_card_first_ing_without_index.nlargest(4, 'Runs'))
//
//        print('\n', team_to_bowl[0].replace('_', ' '))
//        print(df_bowler_list_first_ing_without_index.nlargest(3, 'Wickets'))
//
//        print('\n\nTotal', first_ing_total, '/', first_ing_wickets)
//        print('\n')
//
//        print('------------------------------------------------------Second Innings Top Performers---------------------------------\n\n')
//        print(team_to_bowl[0].replace('_', ' '))
//        print(df_score_card_second_ing_without_index.nlargest(4, 'Runs'))
//
//        print('\n', team_to_bat[0].replace('_', ' '))
//        print(df_bowler_list_second_ing_without_index.nlargest(3, 'Wickets'))
//
//        print('\n\nTarget', first_ing_total+1)
//        print('Total', second_ing_total, '/', second_ing_wickets)
//        print('\n\n')
//
//    # Match result
//        global winning_team
//        global losing_team
//        is_drawn = 0
//
//        print('\n------------------------------------------------------------Match Result----------------------------------------------\n')
//
//        if (second_ing_total > first_ing_total):
//        match_result = str(team_to_bowl[0].replace('_', ' ')+' Won by ' +
//                str(TOTAL_WICKETS-second_ing_wickets)+' wickets')
//        print(match_result)
//        winning_team = team_to_bowl
//        losing_team = team_to_bat
//
//        elif (second_ing_total < first_ing_total):
//        match_result = str(team_to_bat[0].replace(
//                '_', ' ')+' Won by ' + str(first_ing_total-second_ing_total)+' runs')
//        print(match_result)
//        winning_team = team_to_bat
//        losing_team = team_to_bowl
//
//        elif (second_ing_total == first_ing_total):
//        winning_team = team_to_bat
//        losing_team = team_to_bowl
//        is_drawn = 1
//        print('\n\n-------------------------------------------------------Match drawn-----------------------------------------------\n')
//
//        book = load_workbook(
//                r'E:\\IIT\\1st Year\\1st Trimester\\CM1601 [PRO]  Programming Fundamentals\\Course Work\\tournament\\matches\\' + filename_match + '.xlsx')
//        writer = pd.ExcelWriter(
//                r'E:\\IIT\\1st Year\\1st Trimester\\CM1601 [PRO]  Programming Fundamentals\\Course Work\\tournament\\matches\\' + filename_match + '.xlsx', engine='openpyxl')
//        writer.book = book
//
//        worksheet = book.worksheets[0]
//        worksheet['F27'] = match_toss
//        worksheet['F28'] = match_result
//
//        writer.save()
//        writer.close()
//        print('\n---------------------------------------------------------------------------------------------------------------------\n')
//    # --------------------------------------------------------------------------------------------------Update Points table---------------------------------------------------------------------------------------------
//                update_points_table(winning_team, losing_team, is_drawn)




}
